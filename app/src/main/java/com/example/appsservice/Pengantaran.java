package com.example.appsservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appsservice.api.ApiClient;
import com.example.appsservice.api.ApiInterface;
import com.example.appsservice.model.Antaran;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Pengantaran extends AppCompatActivity implements View.OnClickListener {

    EditText nk, nm, alm, np, iddd;
    String nikk, nam, idd, al, nh,dd;
    Button sav, ex;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.iconba);
        setContentView(R.layout.activity_pengantaran);

        idd = getIntent().getStringExtra("id");
        nk = findViewById(R.id.editnik);
        alm = findViewById(R.id.editalamat);
        nm = findViewById(R.id.editnama);
        np = findViewById(R.id.editnohp);
        iddd = findViewById(R.id.editid);
        iddd.setText(idd);
        ex = findViewById(R.id.exi);
        ex.setOnClickListener(this);
        sav = findViewById(R.id.svv);
        sav.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String kosong = "";
        switch (v.getId()) {
            case R.id.svv:
                nikk = nk.getText().toString();
                nam = nm.getText().toString();
                al = alm.getText().toString();
                nh = np.getText().toString();
                dd = iddd.getText().toString();
                if(nikk.length()==0){
                    nk.setError("Harus Diisi");
                }else if(nam.length()==0) {
                    nm.setError("Harus Diisi");
                }else if(al.length()==0) {
                    alm.setError("Harus Diisi");
                }else if(nh.length()==0) {
                    np.setError("Harus Diisi");
                }else{
                    getantar(nikk, nam, dd, al, nh);
                    nk.setText(kosong);
                    nm.setText(kosong);
                    alm.setText(kosong);
                    np.setText(kosong);
                }
                break;
            case R.id.exi:
                Intent inten = new Intent(Pengantaran.this, MainActivity.class);
                startActivity(inten);
        }
    }

    private void getantar(String nik, String nama, String id, String alam, String np) {

        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<Antaran> antarcal = apiInterface.input(nik, nama, id, alam, np);
        antarcal.enqueue(new Callback<Antaran>() {
            @Override
            public void onResponse(Call<Antaran> call, Response<Antaran> response) {

                if (response.body() != null && response.isSuccessful() && response.body().isStatus()) {
                    Toast.makeText(Pengantaran.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Pengantaran.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Antaran> call, Throwable t) {
                Toast.makeText(Pengantaran.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }



}