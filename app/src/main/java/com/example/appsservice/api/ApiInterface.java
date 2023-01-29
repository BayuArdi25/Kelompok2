package com.example.appsservice.api;

import com.example.appsservice.model.Antaran;
import com.example.appsservice.model.DataModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {


    @GET("serv.php")
    Call<List<DataModel>> getData(
            @Query("key") String keyword
    );

    @FormUrlEncoded
    @POST("inputan.php")
    Call<Antaran> input(
            @Field("nik") String nik,
            @Field("nama") String nama,
            @Field("idservice") String idservice,
            @Field("alamat") String alamat,
            @Field("nohp") String nohp
    );
}
