package com.example.adminservice.modul;

import com.google.gson.annotations.SerializedName;

public class DataAntar {
    @SerializedName("nohp")
    private String noHp;

    @SerializedName("nik")
    private String nik;

    @SerializedName("idservice")
    private String idservice;

    @SerializedName("nama")
    private String nama;

    @SerializedName("alamat")
    private String alamat;

    public String getNoHp() {
        return noHp;
    }

    public String getNik() {
        return nik;
    }

    public String getIdservice() {
        return idservice;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }
}

