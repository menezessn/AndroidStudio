package com.example.recyclerview.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.recyclerview.R;
import com.example.recyclerview.adapter.CarroListAdapter;
import com.example.recyclerview.data.CarroMock;
import com.example.recyclerview.model.Carro;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewHolder.rvCarros = findViewById(R.id.rv_carros);

        CarroMock carroMock = new CarroMock();
        List<Carro> listaCarros = new ArrayList<>();
        listaCarros.addAll(carroMock.getListaCarros());

        //adapter
        CarroListAdapter carroListAdapter = new CarroListAdapter(listaCarros);
        mViewHolder.rvCarros.setAdapter(carroListAdapter);

        //layout
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mViewHolder.rvCarros.setLayoutManager(linearLayoutManager);
    }

    private static class ViewHolder{
        RecyclerView  rvCarros;
    }
}

