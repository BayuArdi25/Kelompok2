package com.example.appsservice.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static final String BASE_URL = "https://paisalkulkas69.000webhostapp.com/";
    private static Retrofit retro;

    public static Retrofit getClient() {
        if (retro==null){
            retro = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retro;
    }


}
