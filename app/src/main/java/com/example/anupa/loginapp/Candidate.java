package com.example.anupa.loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Candidate extends AppCompatActivity {


    private TextView Box1;
    private TextView Box2;
    private Button Can1,Can2;
    String value1,value2;
    Integer c1,c2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidate);

        // Box1=findViewById(R.id.tvCan1);
        // Box2=findViewById(R.id.tvCan2);
        Can1 = findViewById(R.id.btCan1);
        Can2 = findViewById(R.id.btCan2);


        FirebaseDatabase database = FirebaseDatabase.getInstance();

        final DatabaseReference myRef = database.getReference("Can1/Name");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                value1 = dataSnapshot.getValue(String.class);
                // Box1.setText(value1);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                // Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        final DatabaseReference myRe = database.getReference("Can1/Surname");
        myRe.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                value2 = dataSnapshot.getValue(String.class);
                // Box2.setText(value2);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                // Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
        // myRef.setValue(str);
        Can1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                c1 = Integer.parseInt(value1);
                Integer in = c1 + 1;
                String up = in.toString();
                myRef.setValue(up);

                    startActivity(new Intent(Candidate.this,ThankYou.class));
                    finish();

            }
        });

        Can2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c2 = Integer.parseInt(value2);
                Integer in = c2 + 1;
                String up = in.toString();
                myRe.setValue(up);

                    startActivity(new Intent(Candidate.this,ThankYou.class));
                    finish();

            }
        });



    }


}
