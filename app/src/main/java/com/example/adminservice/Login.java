package com.example.adminservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adminservice.api.ApiInterface;
import com.example.adminservice.api.Apiclient;
import com.example.adminservice.modul.Log;
import com.example.adminservice.modul.LoginData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity implements View.OnClickListener {

    EditText uss, pss;
    Button but;
    String user, pass;
    TextView regis;
    ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        uss = findViewById(R.id.uss);
        pss = findViewById(R.id.pss);
        but = findViewById(R.id.but);
        but.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but:
                user = uss.getText().toString();
                pass = pss.getText().toString();
                logi(user, pass);
                break;
        }
    }

    private void logi(String user, String pass) {
        apiInterface = Apiclient.getClient().create(ApiInterface.class);
        Call<Log> logincall = apiInterface.loginResponse(user,pass);
        logincall.enqueue(new Callback<com.example.adminservice.modul.Log>() {
            @Override
            public void onResponse(Call<Log> call, Response<Log> response) {
                if(response.body() != null && response.isSuccessful() && response.body().isStatus()){

                    LoginData loginData = response.body().getData();
                    Toast.makeText(Login.this, response.body().getData().getName(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(Login.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Log> call, Throwable t) {
                Toast.makeText(Login.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }
}