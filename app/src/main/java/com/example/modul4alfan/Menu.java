package com.example.modul4alfan;

import android.os.Parcel;
import android.os.Parcelable;

public class Menu  {
    private String nama;
    private  int image, harga, jumlah, id;

    public Menu(int id, int image, String nama, int harga, int jumlah){
        this.id = id;
        this.nama = nama;
        this.image = image;
        this.harga = harga;
        this.jumlah = jumlah;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama(){
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public  int getImage(){
        return  image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
}
