package com.example.extrasdevoluodevaloresentretelas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView tvResultado;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tvResultado = findViewById(R.id.tv_resultado);
        i = getIntent();

        String nome = i.getExtras().getString("nome");
        String telefone = i.getExtras().getString("telefone");
        String email = i.getExtras().getString("email");
        String endereco = i.getExtras().getString("endereco");

        tvResultado.setText("Seu nome é " + nome + " do email " + email + " e telefone " + telefone + " e mora em " + endereco);
    }
}