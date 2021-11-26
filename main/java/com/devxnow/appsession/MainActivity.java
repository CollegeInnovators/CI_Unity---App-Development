package com.devxnow.appsession;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText email,password;
    private Button login;
    private TextView toregister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //to connect your java and xml you need to use the function called as findViewById();
        //java variable=findViewById(R.id.xmlID);
        email=findViewById(R.id.edittext_email_login);
        password=findViewById(R.id.edittext_password_login);
        login=findViewById(R.id.button_login);
        toregister=findViewById(R.id.textview_toregister);

        toregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(MainActivity.this,RegisterActivty.class);
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
        if(pc==1 && ec==1 && semail.contentEquals("xyz123@gmail.com") && spassword.contentEquals("12345678")){
            Intent i=new Intent(MainActivity.this,WelcomeActvity.class);
            startActivity(i);
            finish();
        }
        else{
            Toast.makeText(MainActivity.this,"LOGIN FAILED!!",Toast.LENGTH_SHORT).show();
        }
    }
}