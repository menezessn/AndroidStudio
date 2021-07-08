package com.example.sharedpreferencesex1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnLogin;
    EditText etUsuario,etSenha;
    SharedPreferences sp;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin = findViewById(R.id.btn_logar);
        etUsuario = findViewById(R.id.et_usuario);
        etSenha = findViewById(R.id.et_senha);

        sp = getSharedPreferences(getString(R.string.login), Context.MODE_PRIVATE);
        String loginSalvo = sp.getString(getString(R.string.login), "");
        etUsuario.setText(loginSalvo);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = etUsuario.getText().toString();
                String senha = etSenha.getText().toString();

                if (usuario.trim().equals("user") && senha.trim().equals("pass")){
                    editor = sp.edit();
                    editor.putString(getString(R.string.login), usuario);
                    editor.apply();
                    Toast.makeText(MainActivity.this, "Login válido", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Login inválido", Toast.LENGTH_SHORT).show();
                }
            }
        });

        }
    }
