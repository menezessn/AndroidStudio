package com.example.olanome;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etNome, etSobrenome;
    Button btnOk;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNome = findViewById(R.id.et_nome);
        etSobrenome = findViewById(R.id.et_sobrenome);
        btnOk = findViewById(R.id.btn_ok);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = etNome.getText().toString();
                String sobrenome = etSobrenome.getText().toString();
                if (nome.isEmpty() || sobrenome.isEmpty()){
                    Toast.makeText(MainActivity.this, "Campos inválidos" , Toast.LENGTH_LONG).show();

                } else{
                    Toast.makeText(MainActivity.this, "Olá " + nome + " " + sobrenome, Toast.LENGTH_LONG ).show();
                }
            }
        });
    }
}