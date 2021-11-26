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

public class RegisterActivty extends AppCompatActivity {
    private EditText email,password,name, phoneno;
    private Button register;
    private TextView tologin;
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

        tologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(RegisterActivty.this,MainActivity.class);
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

        if(ec==1 && phc==1 && nc==1 && pc==1){
            Intent reg=new Intent(RegisterActivty.this,WelcomeActvity.class);
            startActivity(reg);
            finish();
        }
        else{
            Toast.makeText(RegisterActivty.this,"REGISTER FAILED!!", Toast.LENGTH_SHORT).show();
        }
    }
}