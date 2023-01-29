package com.example.appsservice;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.appsservice.model.DataModel;

import java.util.List;

public class Adap extends RecyclerView.Adapter<Adap.AdapterHolder> {
    private Context context;
    private List<DataModel> dtlist;

    public Adap(Context context, List<DataModel> dtlist){
        this.context = context;
        this.dtlist = dtlist;
    }

    @NonNull
    @Override
    public Adap.AdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.viewdata,parent, false);
        AdapterHolder holder = new AdapterHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterHolder holder, int position) {

        DataModel dtmodel = dtlist.get(position);
        String namatoko = dtmodel.getNamatoko();
        String servic = dtmodel.getService();

        holder.nmtoko.setText("Nama Toko: "+namatoko);
        holder.serrr.setText("Service "+servic);
        holder.linear.setOnClickListener(v ->{

            Intent inten = new Intent(context, Detail.class);
            inten.putExtra("intent nama toko", dtmodel.getNamatoko());
            inten.putExtra("intent id", dtmodel.getIdservice());
            inten.putExtra("intent service", dtmodel.getService());
            inten.putExtra("intent alamat", dtmodel.getAlamat());
            inten.putExtra("intent no hp", dtmodel.getNoHp());
            context.startActivity(inten);
        });
    }

    @Override
    public int getItemCount() {
        return dtlist.size();
    }

    public class AdapterHolder extends RecyclerView.ViewHolder {
        TextView nmtoko, serrr;
        ImageView mage;
        LinearLayout linear;
        public AdapterHolder(@NonNull View itemView) {
            super(itemView);
            nmtoko = itemView.findViewById(R.id.namatk);
            serrr = itemView.findViewById(R.id.servi);
            mage = itemView.findViewById(R.id.gambar);
            linear = itemView.findViewById(R.id.linearr);
        }
    }
}
