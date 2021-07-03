package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    Button btnLogin;
    EditText etLoginL, etSenhaLogin;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        btnLogin = findViewById(R.id.btn_login);
        etLoginL = findViewById(R.id.et_l_login);
        etSenhaLogin = findViewById(R.id.et_login_senha);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login = etLoginL.getText().toString().trim();
                String senha = etSenhaLogin.getText().toString().trim();
                i = getIntent();
                String username = i.getExtras().getString("username");
                String password = i.getExtras().getString("password");


                if(login.isEmpty() || senha.isEmpty()){
                    Toast.makeText(LoginActivity.this, "Preencha os campos!", Toast.LENGTH_SHORT).show();
                } else if(login.equals(username) && senha.equals(password)){
                    i = new Intent(LoginActivity.this, SobreActivity.class);
                    startActivity(i);
                } else{
                    Toast.makeText(LoginActivity.this, "Login ou senha inválidos!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}