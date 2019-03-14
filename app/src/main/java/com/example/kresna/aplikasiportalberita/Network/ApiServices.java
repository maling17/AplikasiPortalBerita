package com.example.kresna.aplikasiportalberita.Network;

import com.example.kresna.aplikasiportalberita.Response.ResponseBerita;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServices {

    @GET("tampil_berita.php")
    Call<ResponseBerita> request_show_all_berita();
}
