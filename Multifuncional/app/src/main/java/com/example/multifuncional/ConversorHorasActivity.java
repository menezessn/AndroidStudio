package com.example.multifuncional;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class ConversorHorasActivity extends AppCompatActivity {
    Button btnConverterHoras;
    EditText etHoras;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conversor_horas_layout);
        btnConverterHoras = findViewById(R.id.btn_converterHoras);
        etHoras = findViewById(R.id.et_horas);

        btnConverterHoras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String horaString = etHoras.getText().toString();
                if (horaString.isEmpty()){
                    Toast.makeText(ConversorHorasActivity.this, "Campo vazio!", Toast.LENGTH_SHORT).show();
                } else{
                   double vHoras = Double.parseDouble(horaString);
                   int horasAno = 8760;
                   int horasMes = 720;
                   int horasSemana = 168;
                   int horasDia = 24;
                   int meses, semanas, dias, horas, resto;


                   int anos = (int) vHoras/horasAno;
                   resto = (int) vHoras%horasAno;
                   meses = resto/horasMes;
                   resto = resto%horasMes;
                   semanas = resto/horasSemana;
                   resto = resto%horasSemana;
                   dias = resto/horasDia;
                   resto = resto%horasDia;
                   horas = resto;
                   String texto = anos + " ano(s), " + meses + " mes(es), " + semanas + " semana(s), " + dias + " dia(s) e " + horas + " hora(s).";

                    Toast.makeText(ConversorHorasActivity.this, texto , Toast.LENGTH_LONG).show();
                    etHoras.setText("");
                }
            }
        });

    }
}