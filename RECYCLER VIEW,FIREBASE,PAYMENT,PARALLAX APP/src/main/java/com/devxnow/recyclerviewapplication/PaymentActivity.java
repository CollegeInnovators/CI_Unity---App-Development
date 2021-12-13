package com.devxnow.recyclerviewapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

public class PaymentActivity extends AppCompatActivity implements PaymentResultListener {
    private EditText name,email,number,amount;
    private Button donate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        Checkout.preload(getApplicationContext());

        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        number=findViewById(R.id.number);
        amount=findViewById(R.id.amount);
        donate=findViewById(R.id.donate);

        donate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makepayment();
            }
        });
    }
    private void makepayment() {
        String sname,semail,snumber,samount;
        sname=name.getText().toString();
        snumber=number.getText().toString();
        semail=email.getText().toString();
        samount=amount.getText().toString();

        Checkout checkout = new Checkout();
        checkout.setKeyID("rzp_test_yeb0luDyep00wI");
        checkout.setImage(R.drawable.ci_logo);
        final Activity activity = this;
        try {
            JSONObject options = new JSONObject();

            options.put("name", sname);
            options.put("description", "Reference No. #123456");
            options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
            // options.put("order_id", "order_DBJOWzybf0sJbb");//from response of step 3.
            options.put("theme.color", "#000000");
            options.put("currency", "INR");
            options.put("amount", samount);//write amount in paise
            options.put("email", semail);
            options.put("contact",snumber);
            checkout.open(activity, options);
        } catch(Exception e) {
            Log.e("TAG", "Error in starting Razorpay Checkout", e);
        }
    }

    @Override
    public void onPaymentSuccess(String s) {
        Toast.makeText(this, "PAYMENT SUCCESSFUL WITH ID: "+s, Toast.LENGTH_SHORT).show();
        Intent success=new Intent(PaymentActivity.this,HomeActivity.class);
        startActivity(success);
        finish();
    }

    @Override
    public void onPaymentError(int i, String s) {
        Toast.makeText(this, "PAYMENT UNSUCCESSFUL", Toast.LENGTH_SHORT).show();
    }
}