package com.example.adminservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity implements View.OnClickListener {

    Button mas,te;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mas = findViewById(R.id.masuk);
        te = findViewById(R.id.ten);
        mas.setOnClickListener(this);
        te.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.masuk:
                Intent inten = new Intent(Home.this, Login.class);
                startActivity(inten);
                break;
            case R.id.ten:
                Intent in = new Intent(Home.this, tentang.class);
                startActivity(in);
                break;
        }
    }
}