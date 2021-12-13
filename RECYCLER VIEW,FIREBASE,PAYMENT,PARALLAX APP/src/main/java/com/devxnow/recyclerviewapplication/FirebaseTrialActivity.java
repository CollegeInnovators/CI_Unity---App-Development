package com.devxnow.recyclerviewapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class FirebaseTrialActivity extends AppCompatActivity {
    private EditText message;
    private Button send;
    private DatabaseReference databaseReference;
    private TextView readTextView;
    private Button read,update,delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_trial);
        message=findViewById(R.id.messagefirebase);
        send=findViewById(R.id.sendmessagefirebase);
        read=findViewById(R.id.readmessagefirebase);
        readTextView=findViewById(R.id.readdatatextview);
        update=findViewById(R.id.update);
        delete=findViewById(R.id.delete);

        databaseReference= FirebaseDatabase.getInstance().getReference().child("Users");
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data=message.getText().toString();
                databaseReference.child("USER 2").setValue(data).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(FirebaseTrialActivity.this, "MESSAGE SENT SUCCESSFULLY", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(FirebaseTrialActivity.this, "SORRY PERMISSION HAS BEEN DENIED", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.child("USER 2").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()){
                            String data=snapshot.getValue().toString();
                            readTextView.setText(data);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data=message.getText().toString();
                HashMap hashMap=new HashMap();
                hashMap.put("USER 2",data);

                databaseReference.updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {
                        Toast.makeText(FirebaseTrialActivity.this, "YOUR DATA IS SUCCESSFULLY UPDATED", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.child("USER 2").removeValue();
            }
        });
    }
}