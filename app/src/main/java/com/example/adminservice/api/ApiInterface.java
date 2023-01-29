package com.example.adminservice.api;
import com.example.adminservice.modul.Antaran;
import com.example.adminservice.modul.DataAntar;
import com.example.adminservice.modul.DataModel;
import com.example.adminservice.modul.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("log.php")
    Call<Log> loginResponse(
            @Field("username") String username,
            @Field("password") String password
    );

    @GET("serv.php")
    Call<List<DataModel>> getData();

    @GET("datan.php")
    Call<List<DataAntar>> getdat();

    @FormUrlEncoded
    @POST("inputser.php")
    Call<Antaran> input(
            @Field("idservice") String idservice,
            @Field("namatoko") String namatoko,
            @Field("service") String service,
            @Field("alamat") String alamat,
            @Field("no_hp") String no_hp
    );
}
