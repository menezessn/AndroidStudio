package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etValor;
    TextView tvValor;
    Button btnOk;
    SharedPreferences valor;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etValor = findViewById(R.id.et_valor);
        tvValor = findViewById(R.id.tv_valor);
        btnOk = findViewById(R.id.btn_ok);
        valor = getSharedPreferences(getString(R.string.valor), Context.MODE_PRIVATE);
        String result = valor.getString(getString(R.string.valor),"");
        tvValor.setText("Valor: " + result);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor = valor.edit();
                editor.putString(getString(R.string.valor), etValor.getText().toString());
                editor.apply();
                tvValor.setText("Valor: " + etValor.getText().toString());
            }
        });
    }
}