package com.example.modul4alfan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText username, password;
    Button submit;
    String user, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        submit = findViewById(R.id.submit);

        user = "agam";
        pass = "agam";

        Intent back = getIntent();
        String backa = back.getStringExtra("user");
        String backb = back.getStringExtra("pass");
        username.setText(backa);
        username.setText(backb);
    }

    public void loginAct(View view) {
        Intent secondAct = new Intent(this, MainActivity.class);
        if (username.getText().toString().isEmpty() ){
            username.setError("Username Required");

        }
        if (password.getText().toString().isEmpty()){
            password.setError("Password Required");
        }

        else{
            if (username.getText().toString().matches(user) && password.getText().toString().matches(pass)){
                String account = username.getText().toString();
                secondAct.putExtra("accountLogin", account);
                startActivity(secondAct);
            }
            else if (!username.getText().toString().equals(user)){
                username.setError("Username Salah");
            }
            else if (!password.getText().toString().equals(user)){
                password.setError("Password Salah");
            }
        }

    }
}

