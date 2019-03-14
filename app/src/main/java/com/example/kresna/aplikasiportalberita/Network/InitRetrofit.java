package com.example.kresna.aplikasiportalberita.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InitRetrofit {

    public static String API_URL = "http://192.168.1.9/Berita/ ";

    public static Retrofit setInit() {
        return new Retrofit.Builder().baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();


    }

    public static ApiServices getInstance() {
        return setInit().create(ApiServices.class);
    }

}
