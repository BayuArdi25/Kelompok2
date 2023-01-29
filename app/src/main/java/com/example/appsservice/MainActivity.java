package com.example.appsservice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appsservice.api.ApiClient;
import com.example.appsservice.api.ApiInterface;
import com.example.appsservice.model.DataModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView namatok,serv;
    RecyclerView recy;
    Adap adp;
    LinearLayoutManager linearLayoutManager;
    List<DataModel> data;
    ApiInterface api;
    ProgressBar barr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.iconba);
        setContentView(R.layout.activity_main);

        barr = findViewById(R.id.prograss);
        namatok = findViewById(R.id.namatk);
        serv = findViewById(R.id.servi);
        recy = findViewById(R.id.recyclerv);

        linearLayoutManager = new LinearLayoutManager(this);
        recy.setLayoutManager(linearLayoutManager);
        recy.setHasFixedSize(true);
        fetchservicea("");
    }

    public void fetchservicea(String key){
        api = ApiClient.getClient().create(ApiInterface.class);
        Call<List<DataModel>> call = api.getData(key);
        call.enqueue(new Callback<List<DataModel>>(){
            @Override
            public void onResponse(Call<List<DataModel>> call, Response<List<DataModel>> response) {
                    barr.setVisibility(View.GONE);
                    data = response.body();
                    adp = new Adap(MainActivity.this, data);
                    recy.setAdapter(adp);
                    adp.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<DataModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                barr.setVisibility(View.GONE);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.searchmenu, menu);
        SearchManager searchma = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.carimenu).getActionView();
        searchView.setSearchableInfo(
                searchma.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(false);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                fetchservicea(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                fetchservicea(newText);
                return false;
            }
        });
        return true;
    }
}