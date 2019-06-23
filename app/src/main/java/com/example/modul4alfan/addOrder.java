package com.example.modul4alfan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class addOrder extends AppCompatActivity {
    TextView show;
    Button plus, minus, save;
    EditText amount;
    RadioButton cold, hot;
    String pesanBatas;
    ImageView img;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_order);

        img = findViewById(R.id.gambar1);
        show = findViewById(R.id.txt1);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        save = findViewById(R.id.save);
        amount = findViewById(R.id.amount);
        cold = findViewById(R.id.rd1);
        hot = findViewById(R.id.rd2);
        pesanBatas = "Maksimal pesanan hanya 10";

        id = getIntent().getIntExtra("choose", 0);
        show.setText(MainActivity.menuArrayList.get(id).getNama());
        img.setImageResource(MainActivity.menuArrayList.get(id).getImage());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void kurang(View view) {
        if (amount.getText().toString().isEmpty()){
            amount.setText("1");
        }
        else{
            amount.setText(Integer.toString(Integer.parseInt(amount.getText().toString())-1));
            if (Integer.parseInt(amount.getText().toString())<0){
                amount.setText("0");
            }
        }
    }

    public void tambah(View view) {
        if (amount.getText().toString().isEmpty()){
            amount.setText("1");
        }
        else{
            amount.setText(Integer.toString(Integer.parseInt(amount.getText().toString())+1));
            if (Integer.parseInt(amount.getText().toString())>10){
                amount.setText("10");
                Toast.makeText(getApplicationContext(), pesanBatas, Toast.LENGTH_LONG).show();
            }
        }
    }

    public void simpan(View view) {
        if (amount.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(), "Masukkan jumlah pesanan", Toast.LENGTH_LONG).show();
        }
        else if (Integer.parseInt(amount.getText().toString())>10){
            Toast.makeText(getApplicationContext(), "Pesanan maksimal 10 item", Toast.LENGTH_LONG).show();
        }
        else {
            MainActivity.menuArrayList.get(id).setJumlah(Integer.parseInt(amount.getText().toString()));
            finish();
        }
    }
}
