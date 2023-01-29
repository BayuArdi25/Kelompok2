package com.example.appsservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class Awalan extends AppCompatActivity implements View.OnClickListener {

    Button masu, pand;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_awalan);

        masu = findViewById(R.id.masuk);
        masu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.masuk:
                Intent inten = new Intent(Awalan.this, MainActivity.class);
                startActivity(inten);
                break;
        }
    }
}