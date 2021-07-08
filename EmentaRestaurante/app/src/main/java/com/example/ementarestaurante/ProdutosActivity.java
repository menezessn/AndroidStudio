package com.example.ementarestaurante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class ProdutosActivity extends AppCompatActivity {
    CheckBox cbCafe, cbAgua, cbSuco, cbRefrigerante, cbCha;
    Button btnFinalizar;
    EditText etQtdCafe, etQtdAgua, etQtdSuco, etQtdRefrigerante, etQtdCha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.produtos_layout);
        cbCafe = findViewById(R.id.cb_cafe);
        cbAgua = findViewById(R.id.cb_agua);
        cbSuco = findViewById(R.id.cb_suco);
        cbRefrigerante = findViewById(R.id.cb_refrigerante);
        cbCha = findViewById(R.id.cb_cha);
        etQtdCafe = findViewById(R.id.et_qtdCafe);
        etQtdAgua = findViewById(R.id.et_qtdAgua);
        etQtdSuco = findViewById(R.id.et_qtdSuco);
        etQtdRefrigerante = findViewById(R.id.et_qtdRefrigerante);
        etQtdCha = findViewById(R.id.et_qtdCha);

        btnFinalizar = findViewById(R.id.btn_finalizar);

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pedido = "";
                double total = 0;
                double precoCafe = 1.50, precoCha = 2.00, precoRefrigerante = 5.00, precoSuco = 2.50, precoAgua = 1.00;
                if (cbCafe.isChecked()) {
                    int qtdCafe = Integer.parseInt(etQtdCafe.getText().toString());
                    pedido += qtdCafe + " Café " + " R$ " + qtdCafe * precoCafe + "\n";
                    total += qtdCafe * precoCafe;
                }
                if (cbCha.isChecked()) {
                    int qtdCha = Integer.parseInt(etQtdCha.getText().toString());
                    pedido += qtdCha + " Chá " + " R$ " + qtdCha * precoCha + "\n";
                    total += qtdCha * precoCha;
                }
                if (cbSuco.isChecked()) {
                    int qtdSuco = Integer.parseInt(etQtdSuco.getText().toString());
                    pedido += qtdSuco + " Café " + " R$ " + qtdSuco * precoSuco + "\n";
                    total += qtdSuco * precoSuco;
                }
                if (cbRefrigerante.isChecked()) {
                    int qtdRefrigerante = Integer.parseInt(etQtdRefrigerante.getText().toString());
                    pedido += qtdRefrigerante + " Café " + " R$ " + qtdRefrigerante * precoRefrigerante+ "\n";
                    total += qtdRefrigerante * precoRefrigerante;
                }
                if (cbAgua.isChecked()) {
                    int qtdAgua = Integer.parseInt(etQtdAgua.getText().toString());
                    pedido += qtdAgua + " Café " + " R$ " + qtdAgua * precoAgua + "\n\n";
                    total += qtdAgua * qtdAgua;
                }

                Intent i = new Intent(ProdutosActivity.this, CarregamentoActivity.class);
                i.putExtra("pedido" , pedido);
                i.putExtra("total" , "Valor total: R$ " + String.valueOf(total + "\n"));
                startActivity(i);

            }
        });

    }
}