package com.example.login;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    Button btnCadastro, btnLogin, btnSobre;
    String username = "";
    String password = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);
        btnCadastro = findViewById(R.id.btn_cadastro);
        btnLogin = findViewById(R.id.btn_login);
        btnSobre = findViewById(R.id.btn_sobre);


        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, CadastroActivity.class);
                startActivityForResult(i, 1);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, LoginActivity.class);
                if(username.equals("") || password.equals("")){
                    Toast.makeText(MenuActivity.this, "É preciso se cadastrar primeiro", Toast.LENGTH_SHORT).show();
                }else{
                    i.putExtra("username" , username);
                    i.putExtra("password" , password);
                    startActivity(i);
                }
            }
        });
        btnSobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, SobreActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode ==1 && data !=null){
            username = data.getExtras().getString("username");
            password = data.getExtras().getString("password");
            Toast.makeText(this, "Dados de login atualizados!", Toast.LENGTH_SHORT).show();
        }
    }
}