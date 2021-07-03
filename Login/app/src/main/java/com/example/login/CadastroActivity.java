package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroActivity extends AppCompatActivity {
    Button  btnCadastro;
    EditText etSenhaCadastro,etLoginCadastro;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_layout);
        btnCadastro = findViewById(R.id.btn_cadastro);
        etLoginCadastro = findViewById(R.id.et_cadastro_login);
        etSenhaCadastro = findViewById(R.id.et_cadastro_senha);

        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login = etLoginCadastro.getText().toString();
                String senha = etSenhaCadastro.getText().toString();

                if (login.isEmpty() || senha.isEmpty()){
                    Toast.makeText(CadastroActivity.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                } else{
                    i = getIntent();
                    i.putExtra("username", login);
                    i.putExtra("password" , senha);
                    setResult(1, i);
                    finish();
                }
            }
        });

    }
}