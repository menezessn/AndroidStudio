package com.example.mapslistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    ArrayList<Lugar> lista;
    ArrayAdapter<Lugar> adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lv);

        lista = new ArrayList<>();
        lista.add(new Lugar("São Paulo", "Brasil", -23.550520, -46.633308));
        lista.add(new Lugar("Liverpool", "Inglaterra", 53.408371, -2.991573));

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lista);

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this, MapsActivity.class);
                i.putExtra("nome", lista.get(position).getNome());
                i.putExtra("endereco", lista.get(position).getEndereco());
                i.putExtra("latitude", lista.get(position).getLatitude());
                i.putExtra("longitude", lista.get(position).getLongitude());
                startActivity(i);
            }
        });

    }
}