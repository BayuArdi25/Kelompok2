package com.example.appsservice.model;

public class Data{
	private String nik;
	private String nama;
	private String nohp;
	private String idservice;
	private String alamat;

	public void setNik(String nik){
		this.nik = nik;
	}

	public String getNik(){
		return nik;
	}

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setNohp(String nohp){
		this.nohp = nohp;
	}

	public String getNohp(){
		return nohp;
	}

	public void setIdservice(String idservice){
		this.idservice = idservice;
	}

	public String getIdservice(){
		return idservice;
	}

	public void setAlamat(String alamat){
		this.alamat = alamat;
	}

	public String getAlamat(){
		return alamat;
	}
}
