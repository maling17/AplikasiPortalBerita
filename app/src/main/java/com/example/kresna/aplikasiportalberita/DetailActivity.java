package com.example.kresna.aplikasiportalberita;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Objects;

public class DetailActivity extends AppCompatActivity {

    private TextView tvPenulis;
    private TextView tvTglTerbit;
    private ImageView ivGambarBerita;
    private WebView wvKontenBerita;
    private WebView wvKontenBerita1;
    private TextView tvisi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ivGambarBerita = (ImageView) findViewById(R.id.ivGambarBerita);
        tvTglTerbit = (TextView) findViewById(R.id.tvTglTerbit);
        tvPenulis = (TextView) findViewById(R.id.tvPenulis);
//        wvKontenBerita1 = (WebView) findViewById(R.id.wvKontenBerita);
        tvisi = findViewById(R.id.TvIsi);

        showBerita();
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void showBerita() {

        String Judul = getIntent().getStringExtra("JDL_BERITA");
        String Penulis = getIntent().getStringExtra("PNS_BERITA");
        String Tgl = getIntent().getStringExtra("TGL_BERITA");
        String Isi = getIntent().getStringExtra("ISI_BERITA");
        String Foto = getIntent().getStringExtra("GBR_BERITA");

        Objects.requireNonNull(getSupportActionBar()).setTitle(Judul);
        tvPenulis.setText(Penulis);
        tvTglTerbit.setText(Tgl);
//        wvKontenBerita.getSettings().setJavaScriptEnabled(true);
//        wvKontenBerita.loadData(Isi, "text/html; charset=utf-8", "UTF-8");
        Picasso.get().load(Foto).into(ivGambarBerita);
        tvisi.setText(Isi);
    }
}
