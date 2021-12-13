package com.devxnow.recyclerviewapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Display;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;

    ModelClass[] modelClasses={
        new ModelClass("Anisha C.","I am fine, thank you!!","11:00 PM",R.drawable.anisha),
        new ModelClass("Arjuna","I received the notes","1:00 PM",R.drawable.arjuna),
        new ModelClass("Dad","Thank you for your support for me at CI","11:00 AM",R.drawable.dad),
        new ModelClass("Jennifer S.","Can you tell me what happened in class?","3:00 PM",R.drawable.jenny),
        new ModelClass("Karan M.","Amazing Designs man, I really liked them","12:00 AM",R.drawable.karan),
        new ModelClass("Mom","THank you so much for your support","11:00 PM",R.drawable.mum),
        new ModelClass("Nayana K.","Congratulations on getting selected for a new job!!!","10:00 AM",R.drawable.nayana),
        new ModelClass("Royston S.","I checked the website, it looks FAB!!!","8:30 PM",R.drawable.royston),
        new ModelClass("Sherly S.","Thank you for the assignment copy","12:00 PM", R.drawable.sherly),
        new ModelClass("Simran K.","Let's meet tomorrow @3PM in class","1:00 AM",R.drawable.simran)
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerView);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //To get a back arrow on our action bar
        recyclerView.setHasFixedSize(true); //We use this because we know the total size of elements in the recycler view
        linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(linearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager); //This line is used to set our linearlayout manager into our recycler view

        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(recyclerView.getContext(),linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        AdapterClass adapterClass=new AdapterClass(modelClasses);
        recyclerView.setAdapter(adapterClass);
    }

    @Override
    public boolean onSupportNavigateUp() {
        Intent i=new Intent(MainActivity.this,HomeActivity.class);
        startActivity(i);
        finish();
        return true;
    }
}