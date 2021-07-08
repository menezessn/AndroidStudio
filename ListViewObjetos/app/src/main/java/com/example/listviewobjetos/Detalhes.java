package com.example.listviewobjetos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Detalhes extends AppCompatActivity {
    Intent i;
    TextView etNome, etEmail, etEndereco;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalhes_layout);

        etEmail = findViewById(R.id.et_email);
        etEndereco = findViewById(R.id.et_endereco);
        etNome = findViewById(R.id.et_nome);
        i = getIntent();
        String nome = i.getExtras().getString("nome");
        String email = i.getExtras().getString("email");
        String endereco = i.getExtras().getString("endereco");

        etNome.setText("Nome: " + nome);
        etEmail.setText("Email: " + email);
        etEndereco.setText("Endereço: " + endereco);


    }
}