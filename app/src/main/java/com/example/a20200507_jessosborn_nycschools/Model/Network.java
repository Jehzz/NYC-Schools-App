package com.example.a20200507_jessosborn_nycschools.Model;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Network {
    private static Retrofit retrofit;
    private static final String BASE_URL = "https://data.cityofnewyork.us/resource/";

    public static RetrofitEndpoint initRetrofit() {

        OkHttpClient client = new OkHttpClient.Builder().build();

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofit.create(RetrofitEndpoint.class);
    }
}
