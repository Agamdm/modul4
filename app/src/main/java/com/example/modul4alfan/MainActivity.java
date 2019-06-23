package com.example.modul4alfan;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    RecyclerView recyclerView;
    MenuAdapter adapter;
    public static ArrayList<Menu> menuArrayList;
    Button nota;
    EditText nama_pelanggan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addData();

        recyclerView = findViewById(R.id.recycler_view);
        nota = findViewById(R.id.keranjang);
        nama_pelanggan = findViewById(R.id.nama_pelanggan);
        adapter = new MenuAdapter(this, menuArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
    void addData(){
        menuArrayList = new ArrayList<>();
        menuArrayList.add(new Menu(0, R.drawable.cappucino, "Cappucino", 3000, 0));
        menuArrayList.add(new Menu(1, R.drawable.moccacino, "Moccacino", 4000, 0));
        menuArrayList.add(new Menu(2, R.drawable.cocholatos, "Cocholatos", 5000, 0));
    }
    public boolean onCreateOptionsMenu(android.view.Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menu1:
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Selamat Datang di Coffe Store\nMoh Alfan NOurussalam\n160411100122");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                return true;
            case R.id.menu2:
                Intent backToLogin = new Intent(this, Login.class);
                backToLogin.putExtra("user", "");
                backToLogin.putExtra("pass", "");
                startActivity(backToLogin);
                finish();
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void cekNota(View view) {
        if (nama_pelanggan.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(), "Nama pelanggan masih kosong", Toast.LENGTH_LONG).show();
        }
        else {
            boolean check = false;
            for (int i=0; i < menuArrayList.size(); i++){
                if (menuArrayList.get(i).getJumlah() > 0){
                    check = true;
                    break;
                }
            }
            if (check == false){
                Toast.makeText(this, "Anda belum mempunyai pesanan", Toast.LENGTH_SHORT).show();
            }
            else {
                Intent notaAct = new Intent(this, Nota.class);
                notaAct.putExtra("user", nama_pelanggan.getText().toString());
                startActivity(notaAct);
                //finish();
            }

        }
    }
}
