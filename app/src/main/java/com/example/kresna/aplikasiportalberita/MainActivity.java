package com.example.kresna.aplikasiportalberita;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.kresna.aplikasiportalberita.Network.ApiServices;
import com.example.kresna.aplikasiportalberita.Network.InitRetrofit;
import com.example.kresna.aplikasiportalberita.Response.BeritaItem;
import com.example.kresna.aplikasiportalberita.Response.ResponseBerita;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvListBerita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvListBerita = findViewById(R.id.rvListBerita);
        rvListBerita.setHasFixedSize(true);
        rvListBerita.setItemAnimator(new DefaultItemAnimator());

        rvListBerita.setLayoutManager(new LinearLayoutManager(this));
        tampilBerita();
    }

    private void tampilBerita() {

        ApiServices apiServices = InitRetrofit.getInstance();
        Call<ResponseBerita> beritaCall = apiServices.request_show_all_berita();
        beritaCall.enqueue(new Callback<ResponseBerita>() {
            @Override
            public void onResponse(Call<ResponseBerita> call, Response<ResponseBerita> response) {
                if (response.isSuccessful()) {
                    Log.d("response api", response.body().toString());
                    List<BeritaItem> data_berita = response.body().getBerita();
                    boolean status = response.body().isStatus();
                    if (status) {
                        AdapterBerita adapterBerita = new AdapterBerita(MainActivity.this, data_berita);
                        rvListBerita.setAdapter(adapterBerita);
                    } else {
                        Toast.makeText(MainActivity.this, "tidak ada berita untuk saat ini", Toast.LENGTH_LONG).show();

                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBerita> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
