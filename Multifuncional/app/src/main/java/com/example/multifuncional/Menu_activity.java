package com.example.multifuncional;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class Menu_activity extends AppCompatActivity {
    Button btnConversor, btnHoras, btnPrimos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);
        btnConversor = findViewById(R.id.btn_conversor);
        btnHoras = findViewById(R.id.btn_horas);
        btnPrimos = findViewById(R.id.btn_primos);

        btnConversor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu_activity.this, ConversorMoeda_activity.class);
                startActivity(i);
            }
        });

        btnHoras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu_activity.this, ConversorHorasActivity.class);
                startActivity(i);

            }
        });

        btnPrimos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu_activity.this, NumerosPrimosActivity.class);
                startActivity(i);
            }
        });
    }
}