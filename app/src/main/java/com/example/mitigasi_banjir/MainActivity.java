package com.example.mitigasi_banjir;

import static com.example.mitigasi_banjir.R.*;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView intent;
    private TextView tt;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        intent = findViewById(id.intent);
        tt = findViewById(id.ttg);

        intent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, infoair.class);
                startActivity(intent);
            }
        });

        tt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tt = new Intent(MainActivity.this, tentang.class);
                startActivity(tt);
            }
        });

















    }
}