package com.example.conversortemperatura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText edt_TempC;
    Button btn_converter;
    TextView tv_resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_TempC = findViewById(R.id.edt_tempC);
        btn_converter = findViewById(R.id.btn_converter);
        tv_resultado = findViewById(R.id.tv_resultado);

        btn_converter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double tempC = Double.parseDouble(edt_TempC.getText().toString());
                DecimalFormat arredondar = new DecimalFormat("#.##");
                Double tempF = Double.parseDouble(arredondar.format(tempC*9/5+32));
                tv_resultado.setText(String.valueOf(tempF));

            }
        });

    }
}