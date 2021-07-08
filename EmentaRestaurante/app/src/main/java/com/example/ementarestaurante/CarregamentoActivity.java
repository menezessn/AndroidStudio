package com.example.ementarestaurante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class CarregamentoActivity extends AppCompatActivity {
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carregamento_layout);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                i = getIntent();
                String pedido = i.getExtras().getString("pedido");
                String total = i.getExtras().getString("total");
                i = new Intent(CarregamentoActivity.this, PedidoActivity.class);
                i.putExtra("pedido", pedido);
                i.putExtra("total" , total);
                startActivity(i);
                finish();
            }
        },3000);

    }
}