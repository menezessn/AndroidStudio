package com.example.extras;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnMudarNome;
    TextView etNome;
    String nome = "Utilizador";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMudarNome = findViewById(R.id.btn_mudarNome);
        etNome = findViewById(R.id.tv_nome);
        etNome.setText("Olá " + nome);

        btnMudarNome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                i.putExtra("nome", nome);
                startActivityForResult(i, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1 && resultCode==1 && data!=null){
            nome = data.getExtras().getString("nome");
            etNome.setText("Olá " + nome);
        }else {
            Toast.makeText(this, "Result inválido", Toast.LENGTH_SHORT).show();
        }
    }
}