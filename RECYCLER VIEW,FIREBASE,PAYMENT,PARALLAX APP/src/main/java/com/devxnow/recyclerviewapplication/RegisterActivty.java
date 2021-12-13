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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivty extends AppCompatActivity {
    private EditText email,password,name, phoneno;
    private Button register;
    private TextView tologin;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_activty);
        email=findViewById(R.id.edittext_email_register);
        password=findViewById(R.id.edittext_password_register);
        name=findViewById(R.id.edittext_name_register);
        phoneno=findViewById(R.id.edittext_phone_register);
        register=findViewById(R.id.button_register);
        tologin=findViewById(R.id.textview_tologin);
        firebaseAuth=FirebaseAuth.getInstance();



        tologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(RegisterActivty.this,LoginActivity.class);
                startActivity(i2);
                finish();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifySignUp();
            }
        });
    }

    private void verifySignUp() {
        String semail,spassword,sname,sphone;
        int pc=0,ec=0,nc=0,phc=0;

        semail=email.getText().toString();
        sname=name.getText().toString();
        sphone=phoneno.getText().toString();
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
        if(sname.isEmpty() || sname.length()<6){
            name.setError("INVAILD NAME");
            nc=0;
        }
        else{
            name.setError(null);
            nc=1;
        }
        if(sphone.isEmpty() || sphone.length()!=10){
            phoneno.setError("INVALID PHONE NUMBER");
            phc=0;
        }
        else{
            phoneno.setError(null);
            phc=1;
        }

        firebaseAuth.createUserWithEmailAndPassword(semail,spassword).addOnCompleteListener(RegisterActivty.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(!task.isSuccessful()){
                    Toast.makeText(RegisterActivty.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show(); //Whatever the reason for my account to not get created will be displayed in toast message.
                }
                else{
                    String user_id=firebaseAuth.getCurrentUser().getUid();
                    DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference().child("Users").child("ID").child(user_id);
                    databaseReference.child("Name").setValue(sname);
                    databaseReference.child("Email").setValue(semail);
                    databaseReference.child("Phone number").setValue(sphone);
                    Intent i=new Intent(RegisterActivty.this,HomeActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        });
    }
}
