package com.example.kresna.aplikasiportalberita;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kresna.aplikasiportalberita.Response.BeritaItem;
import com.squareup.picasso.Picasso;

import java.util.List;

class AdapterBerita extends RecyclerView.Adapter<AdapterBerita.MyViewHolder> {

    Context context;
    List<BeritaItem> berita;

    public AdapterBerita(Context context, List<BeritaItem> berita) {
        this.context = context;
        this.berita = berita;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.berita_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.tvJudul.setText(berita.get(position).getJudulBerita());
        holder.tvTglTerbit.setText(berita.get(position).getTanggalPosting());

        final String Url_Gambar_Berita = "http://192.168.1.9/Berita/images/" + berita.get(position).getFoto();
        Picasso.get().load(Url_Gambar_Berita).into(holder.ivGambarBerita);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent varIntent = new Intent(context, DetailActivity.class);
                varIntent.putExtra("JDL_BERITA", berita.get(position).getJudulBerita());
                varIntent.putExtra("TGL_BERITA", berita.get(position).getTanggalPosting());
                varIntent.putExtra("PNS_BERITA", berita.get(position).getPenulis());
                varIntent.putExtra("ISI_BERITA", berita.get(position).getIsiBerita());
                varIntent.putExtra("GBR_BERITA", Url_Gambar_Berita);

                context.startActivity(varIntent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return berita.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView ivGambarBerita;
        TextView tvJudul, tvTglTerbit, tvPenulis;

        public MyViewHolder(View itemView) {
            super(itemView);
            // inisialisasi widget
            ivGambarBerita = (ImageView) itemView.findViewById(R.id.ivPosterBerita);
            tvJudul = (TextView) itemView.findViewById(R.id.tvJudulBerita);
            tvTglTerbit = (TextView) itemView.findViewById(R.id.tvTglTerbit);
            tvPenulis = (TextView) itemView.findViewById(R.id.tvPenulis);
        }
    }
}
