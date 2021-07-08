 package com.example.listas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

 public class MainActivity extends AppCompatActivity {
    ListView lv;
    ArrayList<String> nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.lv);
        nome = new ArrayList<>();
        nome.add("Marcelo");
        nome.add("Bianca");
        nome.add("Juliana");
        nome.add("Arnaldo");
        nome.add("José");
        nome.add("João");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nome);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Toast.makeText(MainActivity.this, "Olá " + nome.get(position), Toast.LENGTH_SHORT).show();

            }
        });

    }
}