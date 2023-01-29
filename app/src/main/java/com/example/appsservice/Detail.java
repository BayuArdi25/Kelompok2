package com.example.appsservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Detail extends AppCompatActivity {

    FloatingActionButton buttt;
    TextView na, se, al, hpp, idd;
    private final String TAG = "Detail";
    String ii;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.iconba);
        String namtok = getIntent().getStringExtra("intent nama toko");
        String servik = getIntent().getStringExtra("intent service");
        String almm = getIntent().getStringExtra("intent alamat");
        String hp = getIntent().getStringExtra("intent no hp");
        String id = getIntent().getStringExtra("intent id");

        na = findViewById(R.id.namatoko);
        se = findViewById(R.id.service);
        al = findViewById(R.id.alamat);
        hpp = findViewById(R.id.nhp);
        idd = findViewById(R.id.idse);
        buttt = findViewById(R.id.butto);

        na.setText(namtok);
        se.setText(servik);
        al.setText(almm);
        hpp.setText(hp);
        idd.setText(id);

        buttt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ii = idd.getText().toString();
                Intent intent = new Intent(Detail.this, Pengantaran.class);
                intent.putExtra("id", ii);
                startActivity(intent);
            }
        });
    }
}