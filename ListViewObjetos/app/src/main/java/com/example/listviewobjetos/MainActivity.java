package com.example.listviewobjetos;

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
    ArrayList<Estudante> lista;
    ArrayAdapter<Estudante> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.lv);

        lista = new ArrayList<>();
        lista.add(new Estudante("Marcelo", "Rua 1", "marcelo@gmail.com"));
        lista.add(new Estudante("Maria", "Rua 2", "maria@gmail.com"));
        lista.add(new Estudante("Marcos", "Rua 3", "marcos@gmail.com"));
        lista.add(new Estudante("Manuel", "Rua 4", "manuel@gmail.com"));
        lista.add(new Estudante("Marisa", "Rua 5", "marisa@gmail.com"));
        lista.add(new Estudante("Maria Luceli de Menezes", "Avenida Presidente João Goulart 435", "Lucelimenezes@hotmail.com"));
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lista);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this, Detalhes.class);
                i.putExtra("nome", lista.get(position).getNome());
                i.putExtra("email", lista.get(position).getEmail());
                i.putExtra("endereco", lista.get(position).getEndereco());
                startActivity(i);
            }
        });


    }
}