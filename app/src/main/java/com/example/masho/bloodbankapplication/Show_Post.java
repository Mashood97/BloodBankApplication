package com.example.masho.bloodbankapplication;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Show_Post extends AppCompatActivity {

    DatabaseReference reference;
    RecyclerView recyclerView;
    ArrayList<ModelShow> list;
    RecyclerAdapter adapter;
    ModelShow modelShowClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show__post);

        list = new ArrayList<>();

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        //scrolling of recycler view
        recyclerView.scrollToPosition(0);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));

        reference = FirebaseDatabase.getInstance().getReference().child("AddPost");

        reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange( DataSnapshot dataSnapshot) {
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {

                            modelShowClass = dataSnapshot1.getValue(ModelShow.class);
                            list.add(modelShowClass);
                        }
                        adapter = new RecyclerAdapter(Show_Post.this, list);
                        recyclerView.setAdapter(adapter);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Opsss.... Something is wrong", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER| Gravity.BOTTOM, 0,0);
                        toast.show();
                    }
                });
    }


}
