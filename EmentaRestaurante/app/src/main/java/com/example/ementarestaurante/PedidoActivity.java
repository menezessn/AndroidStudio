package com.example.ementarestaurante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class PedidoActivity extends AppCompatActivity {
    TextView tvPedido;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pedido_layout);
        tvPedido = findViewById(R.id.tv_pedido);
        i = getIntent();
        String pedido = i.getExtras().getString("pedido");
        String total = i.getExtras().getString("total");
        tvPedido.setText(pedido + total);
    }
}