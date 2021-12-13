package com.devxnow.recyclerviewapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {
    private EditText email,password;
    private Button login;
    private TextView toregister;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email=findViewById(R.id.edittext_email_login);
        password=findViewById(R.id.edittext_password_login);
        login=findViewById(R.id.button_login);
        toregister=findViewById(R.id.textview_toregister);
        firebaseAuth=FirebaseAuth.getInstance();


        toregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(LoginActivity.this,RegisterActivty.class);
                startActivity(i1);
                finish();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyLogin();
            }
        });
    }

    private void verifyLogin() {
        String semail,spassword;
        int pc=0,ec=0;
        //how to get data out of any edittext
        //SYNTAX
        // LHS - String variable you have declared
        // RHS - java variable you created to build a relationship for that element in java.getText().toString();
        //Example: name (build the relationship), sname (java variable to store the data)
        //sname=name.getText().toString();

        semail=email.getText().toString();
        spassword=password.getText().toString();


        if(semail.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(semail).matches()){
            email.setError("INVALID EMAIL-ID");
            ec=0;
        }
        else{
            email.setError(null);
            ec=1;
        }
        if(spassword.isEmpty() || spassword.length()<8){
            password.setError("INVALID PASSWORD");
            pc=0;
        }
        else{
            password.setError(null);
            pc=1;
        }

        firebaseAuth.signInWithEmailAndPassword(semail,spassword).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
                    if(firebaseUser!=null){
                        DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference().child("Users").child("ID");
                        databaseReference.child(firebaseUser.getUid());
                        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if(snapshot.getValue()!=null){
                                    Intent i=new Intent(LoginActivity.this,HomeActivity.class);
                                    startActivity(i);
                                    finish();
                                    return;
                                }
                                else{
                                    Toast.makeText(LoginActivity.this, "USER DOES NOT EXIST", Toast.LENGTH_SHORT).show();
                                    return;
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
                    }
                    return;
                }
                else{
                    Toast.makeText(LoginActivity.this, "AUTHENTICATION OF USER HAS FAILED", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

}
