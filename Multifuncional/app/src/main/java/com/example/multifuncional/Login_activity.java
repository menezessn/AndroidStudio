package com.example.multifuncional;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login_activity extends AppCompatActivity {
    EditText etUsername, etPassword;
    Button btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        etPassword = findViewById(R.id.et_password);
        etUsername = findViewById(R.id.et_username);
        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                if (username.equals("user") && password.equals("pass")){
                    Intent i = new Intent(Login_activity.this, Menu_activity.class);
                    startActivity(i);
                }else{
                    Toast.makeText(Login_activity.this, "Username ou senha inválidos!", Toast.LENGTH_SHORT).show();
                    etPassword.setText("");
                    etUsername.setText("");
                }

            }
        });

    }
}