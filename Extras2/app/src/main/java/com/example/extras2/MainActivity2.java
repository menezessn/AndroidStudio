package com.example.extras2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    Button btnProximo2;
    EditText etNum2;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btnProximo2 = findViewById(R.id.btn_proximo2);
        etNum2 = findViewById(R.id.et_num2);
        i = getIntent();

        btnProximo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num1 = i.getExtras().getString("num1");

                i = new Intent(MainActivity2.this , MainActivity3.class);
                i.putExtra("num1" , num1);
                i.putExtra("num2" , etNum2.getText().toString());
                startActivity(i);

            }
        });
    }
}