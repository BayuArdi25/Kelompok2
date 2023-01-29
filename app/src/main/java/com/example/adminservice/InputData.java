package com.example.adminservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.adminservice.api.ApiInterface;
import com.example.adminservice.api.Apiclient;
import com.example.adminservice.modul.Antaran;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InputData extends AppCompatActivity implements View.OnClickListener {

    EditText ser, nmtk, alm, np, id;
    String servik, namtok, idd, al, nh;
    Button sav, ex;
    ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data);
        ser = findViewById(R.id.editser);
        alm = findViewById(R.id.editalamat);
        nmtk = findViewById(R.id.editnamatk);
        np = findViewById(R.id.editnohp);
        id = findViewById(R.id.editid);
        ex = findViewById(R.id.exi);
        ex.setOnClickListener(this);
        sav = findViewById(R.id.svv);
        sav.setOnClickListener(this);
    }

    private void getantar(String iddd, String namat, String servii, String alam, String np) {

        apiInterface = Apiclient.getClient().create(ApiInterface.class);
        Call<Antaran> antarcal = apiInterface.input(iddd, namat, servii, alam, np);
        antarcal.enqueue(new Callback<Antaran>() {
            @Override
            public void onResponse(Call<Antaran> call, Response<Antaran> response) {

                if (response.body() != null && response.isSuccessful() && response.body().isStatus()) {
                    Toast.makeText(InputData.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(InputData.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<Antaran> call, Throwable t) {
                Toast.makeText(InputData.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.svv:
                idd = id.getText().toString();
                namtok = nmtk.getText().toString();
                al = alm.getText().toString();
                nh = np.getText().toString();
                servik = ser.getText().toString();
                if(idd.length()==0){
                    id.setError("Harus Diisi");
                }else if(namtok.length()==0) {
                    nmtk.setError("Harus Diisi");
                }else if(al.length()==0) {
                    alm.setError("Harus Diisi");
                }else if(nh.length()==0) {
                    np.setError("Harus Diisi");
                }else if(servik.length()==0){
                    ser.setError("Harus Diisi");
                }else{
                    getantar(idd, namtok, servik, al, nh);
                    Intent inn = new Intent(InputData.this, MainActivity.class);
                    startActivity(inn);
                }
            case R.id.exi:
                Intent inn = new Intent(InputData.this, MainActivity.class);
                startActivity(inn);
        }
    }
}