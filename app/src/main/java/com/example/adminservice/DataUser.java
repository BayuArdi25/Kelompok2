package com.example.adminservice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adminservice.api.ApiInterface;
import com.example.adminservice.api.Apiclient;
import com.example.adminservice.modul.DataAntar;
import com.example.adminservice.modul.DataModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataUser extends AppCompatActivity  {
    List<DataAntar>listmodel;
    TableLayout tab;
    ApiInterface api;
    BottomNavigationView bott;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_user);
        tab = findViewById(R.id.tabll);
        bott = findViewById(R.id.bot);
        initViews();
        bott.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.tamser:
                        Intent inten = new Intent(DataUser.this, MainActivity.class);
                        startActivity(inten);
                        finish();
                        break;
                    case R.id.tampen:
                        Intent intent = new Intent(DataUser.this, DataUser.class);
                        startActivity(intent);
                        finish();
                        break;
                    case R.id.keluar:
                        Intent inte = new Intent(DataUser.this, Home.class);
                        inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
                        startActivity(inte);
                        finish();
                }
                return false;
            }
        });
    }
    @NonNull
    private TableRow.LayoutParams getLayoutParams() {
        TableRow.LayoutParams params = new TableRow.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT);
        params.setMargins(1, 1, 1, 1);
        params.weight = 1;
        return params;
    }

    @NonNull
    private TableLayout.LayoutParams getTblLayoutParams() {
        return new TableLayout.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT);
    }

    public void initViews(){
        api = Apiclient.getClient().create(ApiInterface.class);
        Call<List<DataAntar>> call = api.getdat();
        call.enqueue(new Callback<List<DataAntar>>() {
            @Override
            public void onResponse(Call<List<DataAntar>> call, Response<List<DataAntar>> response) {
                if(response.isSuccessful()){
                    addHeaders();
                    listmodel = response.body();
                    for (int i = 0; i < listmodel.size(); i++) {
                        TableRow tr = new TableRow(DataUser.this);
                        tr.setLayoutParams(getLayoutParams());
                        tr.addView(getRowsTextView(0, listmodel.get(i).getNik(), Color.BLACK, Typeface.BOLD, R.color.white ));
                        tr.addView(getRowsTextView(0, listmodel.get(i).getNama(), Color.BLACK, Typeface.BOLD ,R.color.white ));
                        tr.addView(getRowsTextView(0, listmodel.get(i).getIdservice(), Color.BLACK, Typeface.BOLD ,R.color.white));
                        tr.addView(getRowsTextView(0, listmodel.get(i).getAlamat(), Color.BLACK, Typeface.BOLD ,R.color.white));
                        tr.addView(getRowsTextView(0, listmodel.get(i).getNoHp(), Color.BLACK, Typeface.BOLD ,R.color.white));
                        tab.addView(tr, getTblLayoutParams());
                    }
                }else{
                }
            }

            @Override
            public void onFailure(Call<List<DataAntar>> call, Throwable t) {
                Toast.makeText(DataUser.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void addHeaders() {

        TableRow tr = new TableRow(this);
        tr.setLayoutParams(getLayoutParams());

        tr.addView(getTextView(0, "NIK", Color.WHITE, Typeface.BOLD, R.color.black));
        tr.addView(getTextView(0, "NAMA", Color.WHITE, Typeface.BOLD, R.color.black));
        tr.addView(getTextView(0, "ID SERVICE", Color.WHITE, Typeface.BOLD, R.color.black));
        tr.addView(getTextView(0, "ALAMAT", Color.WHITE, Typeface.BOLD, R.color.black));
        tr.addView(getTextView(0, "NO HP", Color.WHITE, Typeface.BOLD, R.color.black));
        tab.addView(tr, getTblLayoutParams());
    }
    private TextView getTextView(int id, String title, int color, int typeface, int bgColor) {
        TextView tv = new TextView(this);
        tv.setId(id);
        tv.setText(title.toUpperCase());
        tv.setTextColor(color);
        tv.setPadding(10, 10, 10, 10);
        tv.setTypeface(Typeface.DEFAULT, typeface);
        tv.setBackgroundColor(bgColor);
        tv.setBackgroundResource(bgColor);
        tv.setLayoutParams(getLayoutParams());
        return tv;
    }

    private TextView getRowsTextView(int id, String title, int color, int typeface,int bgColor) {
        TextView tv = new TextView(this);
        tv.setId(id);
        tv.setText(title);
        tv.setTextColor(color);
        tv.setPadding(10, 10, 10, 10);
        tv.setTypeface(Typeface.DEFAULT, typeface);
        tv.setBackgroundResource(bgColor);
        tv.setLayoutParams(getLayoutParams());
        return tv;
    }

}