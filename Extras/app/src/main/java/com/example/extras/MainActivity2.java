package com.example.extras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    Button btnSalvar;
    EditText etNome;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btnSalvar = findViewById(R.id.btn_salvar);
        etNome = findViewById(R.id.et_nome);

        i = getIntent();
        etNome.setText(i.getExtras().getString("nome"));

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("nome", etNome.getText().toString());
                setResult(1, i);
                finish();
            }
        });
    }
}