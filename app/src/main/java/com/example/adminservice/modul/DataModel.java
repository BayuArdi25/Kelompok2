package com.example.adminservice.modul;

import com.google.gson.annotations.SerializedName;

public class DataModel {

	@SerializedName("no_hp")
	private String noHp;

	@SerializedName("service")
	private String service;

	@SerializedName("idservice")
	private String idservice;

	@SerializedName("namatoko")
	private String namatoko;

	@SerializedName("alamat")
	private String alamat;

	public String getNoHp() {
		return noHp;
	}

	public String getService() {
		return service;
	}

	public String getIdservice() {
		return idservice;
	}

	public String getNamatoko() {
		return namatoko;
	}

	public String getAlamat() {
		return alamat;
	}
}