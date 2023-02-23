package com.example.mitigasi_banjir;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.widget.EditText;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.Tag;

import java.security.KeyStore;
import java.util.ArrayList;

public class infoair<LineData> extends AppCompatActivity implements ValueEventListener {
    TextView j;
    TextView s;
    TextView t;

    String jarak;
    String status;
    String tinggi;

   DatabaseReference dref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infoair);

        j = (TextView) findViewById(R.id.jarak);
        s = (TextView) findViewById(R.id.status);
        t = (TextView) findViewById(R.id.tinggiair);

        dref = FirebaseDatabase.getInstance().getReference();
        ArrayList<KeyStore.Entry> entries = new ArrayList<>();


        final ValueEventListener valueEventListener = dref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                jarak = snapshot.child("jarak sensor").getValue() != null ? snapshot.child("jarak sensor").getValue().toString() : "";
                j.setText(jarak);

                status = snapshot.child("Status").getValue() != null ? snapshot.child("Status").getValue().toString() : "";
                s.setText(status);

                tinggi = snapshot.child("Ketinggian air").getValue() != null ? snapshot.child("Ketinggian air").getValue().toString() : "";
                t.setText(tinggi);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public void onDataChange (DataSnapshot dataSnapshot) {

        if (dataSnapshot.getValue(String.class) != null) {

            String key = dataSnapshot.getKey();
            if (key.equals("jarak sensor")) {

                String jarak = dataSnapshot.getValue(String.class);
                j.setText(jarak);

            }
            if (key.equals("status")) {

                String status = dataSnapshot.getValue(String.class);
                s.setText(status);
            }

            if (key.equals("ketinggian air")) {

                String tinggi = dataSnapshot.getValue(String.class);
                t.setText(tinggi);
            }
        }

    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }

}


