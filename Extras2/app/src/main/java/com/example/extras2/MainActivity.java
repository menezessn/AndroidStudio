package com.example.extras2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etNum1;
    Button btnProximo1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNum1 = findViewById(R.id.et_num1);
        btnProximo1 = findViewById(R.id.btn_proximo1);

        btnProximo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this , MainActivity2.class);
                i.putExtra("num1" , etNum1.getText().toString());
                startActivity(i);

            }
        });

    }
}