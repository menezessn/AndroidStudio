package com.example.multifuncional;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NumerosPrimosActivity extends AppCompatActivity {
    Button btnVericar;
    EditText etNumero;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.numeros_primos_layout);
        btnVericar = findViewById(R.id.btn_verificar);
        etNumero = findViewById(R.id.et_numero);

        btnVericar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numeroString = etNumero.getText().toString();
                if(numeroString.isEmpty()){
                    Toast.makeText(NumerosPrimosActivity.this, "Campo Vazio!", Toast.LENGTH_SHORT).show();
                }else if(numeroString.equals("0")){
                    Toast.makeText(NumerosPrimosActivity.this, "Não é primo", Toast.LENGTH_SHORT).show();
                }else {

                    int numero = Integer.parseInt(numeroString);
                    boolean primoCheck = true;

                    for (int i = 2; i<numero; i++){
                        if (numero%i ==0){
                            primoCheck = false;
                        }
                    }
                    if (primoCheck){
                        Toast.makeText(NumerosPrimosActivity.this, "O número é primo!", Toast.LENGTH_SHORT).show();
                    } else{
                        Toast.makeText(NumerosPrimosActivity.this, "O número não é primo!", Toast.LENGTH_SHORT).show();
                    }


                }

            }
        });

    }
}