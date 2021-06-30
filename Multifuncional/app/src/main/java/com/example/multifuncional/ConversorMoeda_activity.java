package com.example.multifuncional;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class ConversorMoeda_activity extends AppCompatActivity {
    Button btnDolar, btnEuro, btnPeso;
    EditText etReal;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conversor_moeda_layout);
        btnDolar = findViewById(R.id.btn_dolar);
        btnEuro = findViewById(R.id.btn_euro);
        btnPeso = findViewById(R.id.btn_peso);
        etReal = findViewById(R.id.et_real);
        DecimalFormat arredondar = new DecimalFormat("#.##");


        btnPeso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String etRealString = etReal.getText().toString();


                if (etRealString.isEmpty()){
                    Toast.makeText(ConversorMoeda_activity.this, "O campo está vazio!", Toast.LENGTH_SHORT).show();
                }else{
                    Double etRealArredondar = Double.parseDouble(etRealString);
                    Double vReal = Double.parseDouble(arredondar.format(etRealArredondar));
                    Double vPeso = Double.parseDouble(arredondar.format(vReal/0.05));
                    Toast.makeText(ConversorMoeda_activity.this, "R$" + vReal + " vale P$" + vPeso, Toast.LENGTH_SHORT).show();
                }


            }
        });

        btnEuro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String etRealString = etReal.getText().toString();


                if (etRealString.isEmpty()){
                    Toast.makeText(ConversorMoeda_activity.this, "O campo está vazio!", Toast.LENGTH_SHORT).show();
                }else{
                    Double etRealArredondar = Double.parseDouble(etRealString);
                    Double vReal = Double.parseDouble(arredondar.format(etRealArredondar));
                    Double vEuro = Double.parseDouble(arredondar.format(vReal/6));
                    Toast.makeText(ConversorMoeda_activity.this, "R$" + vReal + " vale EU$" + vEuro, Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnDolar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String etRealString = etReal.getText().toString();


                if (etRealString.isEmpty()){
                    Toast.makeText(ConversorMoeda_activity.this, "O campo está vazio!", Toast.LENGTH_SHORT).show();
                }else{
                    Double etRealArredondar = Double.parseDouble(etRealString);
                    Double vReal = Double.parseDouble(arredondar.format(etRealArredondar));
                    Double vDolar = Double.parseDouble(arredondar.format(vReal/5.09));
                    Toast.makeText(ConversorMoeda_activity.this, "R$" + vReal + " vale US$" + vDolar, Toast.LENGTH_SHORT).show();
                }

            }
        });





    }
}