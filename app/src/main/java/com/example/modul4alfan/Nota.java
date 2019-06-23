package com.example.modul4alfan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Nota extends AppCompatActivity {
    TextView nama_pesanan, harga, jumlah, nama_pemesan, total_pesanan, kembalian;
    String viewmenu = "", viewharga = "", viewjumlah = "";
    int total;
    EditText input_uang;
    Button bayar_btn;
    Locale localID;
    NumberFormat rp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nota);

        nama_pesanan = findViewById(R.id.nm_pesanan);
        harga = findViewById(R.id.harga);
        jumlah = findViewById(R.id.jumlah);
        nama_pemesan = findViewById(R.id.cetakNama);
        total_pesanan = findViewById(R.id.total);
        input_uang = findViewById(R.id.inputan_uang);
        bayar_btn = findViewById(R.id.bayar);
        kembalian = findViewById(R.id.kembalian);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        for (int i = 0; i<MainActivity.menuArrayList.size();i++){
            if (MainActivity.menuArrayList.get(i).getJumlah()>0){
                viewmenu = viewmenu + MainActivity.menuArrayList.get(i).getNama()+"\n\n";
                viewharga = viewharga + MainActivity.menuArrayList.get(i).getHarga()+"\n\n";
                viewjumlah = viewjumlah + MainActivity.menuArrayList.get(i).getJumlah()+"\n\n";
                total = total + (MainActivity.menuArrayList.get(i).getHarga() * MainActivity.menuArrayList.get(i).getJumlah());
            }

        }

        nama_pemesan.setText("NAMA : " + getIntent().getStringExtra("user"));
        nama_pesanan.setText(viewmenu);
        harga.setText(viewharga);
        jumlah.setText(viewjumlah);

        localID = new Locale("in", "ID");
        rp = NumberFormat.getCurrencyInstance(localID);
        total_pesanan.setText("Total : " + rp.format((int)total));

    }

    public void bayar(View view) {
        if (input_uang.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(), "Masukkan Nominal Uang", Toast.LENGTH_LONG).show();
        }
        else if (Integer.parseInt(input_uang.getText().toString())<total){
            Toast.makeText(getApplicationContext(), "Uang Tidak Cukup", Toast.LENGTH_SHORT).show();
        }
        else{
            int kembali = Integer.parseInt(input_uang.getText().toString()) - total;
            kembalian.setText("Kembalian : " + rp.format((int)kembali));
        }
    }
}
