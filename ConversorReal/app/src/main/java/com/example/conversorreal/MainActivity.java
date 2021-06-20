package com.example.conversorreal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.Format;

public class MainActivity extends AppCompatActivity {
    EditText etReal;
    Button btnDolar, btnEuro, btnPeso;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etReal = findViewById(R.id.et_Real);
        btnDolar = findViewById(R.id.btn_Dolar);
        btnEuro = findViewById(R.id.btn_Euro);
        btnPeso = findViewById(R.id.btn_Peso);


        btnDolar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                DecimalFormat arredondar = new DecimalFormat("#.##");
                Double vRealComp = Double.parseDouble(etReal.getText().toString());
                Double vReal = Double.parseDouble(arredondar.format(vRealComp));
                if (vReal !=null ){

                    Double vDolar = Double.parseDouble(arredondar.format(vReal/5.09));
                    Toast.makeText(MainActivity.this, "R$" + vReal + " vale US$ " + vDolar, Toast.LENGTH_LONG).show();

                }else {
                    Toast.makeText(MainActivity.this, "Campo vazio!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnPeso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat arredondar = new DecimalFormat("#.##");
                Double vRealComp = Double.parseDouble(etReal.getText().toString());
                Double vReal = Double.parseDouble(arredondar.format(vRealComp));
                if (vReal !=null ){

                    Double vPeso = Double.parseDouble(arredondar.format(vReal/0.053));
                    Toast.makeText(MainActivity.this, "R$" + vReal + " vale $ " + vPeso, Toast.LENGTH_LONG).show();

                }else {
                    Toast.makeText(MainActivity.this, "Campo vazio!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnEuro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat arredondar = new DecimalFormat("#.##");
                Double vRealComp = Double.parseDouble(etReal.getText().toString());
                Double vReal = Double.parseDouble(arredondar.format(vRealComp));
                if (vReal !=null ){

                    Double vEuro = Double.parseDouble(arredondar.format(vReal/6.04));
                    Toast.makeText(MainActivity.this, "R$" + vReal + " vale EU$ " + vEuro, Toast.LENGTH_LONG).show();

                }else {
                    Toast.makeText(MainActivity.this, "Campo vazio!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}