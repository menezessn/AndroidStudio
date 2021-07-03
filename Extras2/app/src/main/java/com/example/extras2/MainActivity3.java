package com.example.extras2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    TextView tvSoma, tvSubtracao, tvMultiplicacao, tvDivisao;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        tvSoma = findViewById(R.id.tv_soma);
        tvSubtracao = findViewById(R.id.tv_subtracao);
        tvMultiplicacao = findViewById(R.id.tv_multiplicacao);
        tvDivisao = findViewById(R.id.tv_divisao);
        i = getIntent();
        int num1 = Integer.parseInt(i.getExtras().getString("num1"));
        int num2 = Integer.parseInt(i.getExtras().getString("num2"));
        tvSoma.setText(num1 + " + " + num2 + " = " + (num1+num2));
        tvSubtracao.setText(num1 + " - " + num2 + " = " + (num1-num2));
        tvMultiplicacao.setText(num1 + " x " + num2 + " = " + (num1*num2));


        if (num2!=0) {
            double divisao = (double)num1/num2;
            tvDivisao.setText(num1 + " / " + num2 + " = " + (divisao));
        } else{
            tvDivisao.setText("Impossível dividir por zero");
        }

    }
}