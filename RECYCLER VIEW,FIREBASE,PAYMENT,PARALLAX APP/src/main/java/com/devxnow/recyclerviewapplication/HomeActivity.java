package com.devxnow.recyclerviewapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    Button chat,logout;
    private FirebaseAuth firebaseAuth;
    private ImageView banner;
    private ImageSlider imageSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        chat=findViewById(R.id.button);
        logout=findViewById(R.id.logout);
        firebaseAuth=FirebaseAuth.getInstance();
        banner=findViewById(R.id.app_banner);
        imageSlider=findViewById(R.id.slider);

        List<SlideModel> slideModels=new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.slider_1));
        slideModels.add(new SlideModel(R.drawable.slider_2));
        slideModels.add(new SlideModel(R.drawable.slider_3));
        slideModels.add(new SlideModel(R.drawable.slider_4));

        imageSlider.setImageList(slideModels,true);



        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(HomeActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                Intent i=new Intent(HomeActivity.this,LoginActivity.class);
                startActivity(i);
                finish();
            }
        });

        banner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(HomeActivity.this,PaymentActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}