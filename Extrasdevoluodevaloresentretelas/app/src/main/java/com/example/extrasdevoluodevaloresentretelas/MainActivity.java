package com.example.extrasdevoluodevaloresentretelas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etNome, etTelefone, etEmail, etEndereco;
    Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etEmail = findViewById(R.id.et_email);
        etNome = findViewById(R.id.et_nome);
        etTelefone =findViewById(R.id.et_telefone);
        etEndereco = findViewById(R.id.et_endereco);
        btnEnviar = findViewById(R.id.btn_enviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                i.putExtra("email", etEmail.getText().toString());
                i.putExtra("nome", etNome.getText().toString());
                i.putExtra("telefone", etTelefone.getText().toString());
                i.putExtra("endereco", etEndereco.getText().toString());
                startActivity(i);
            }
        });

    }
}