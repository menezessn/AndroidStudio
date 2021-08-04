package com.example.recyclerview.viewholder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;
import com.example.recyclerview.model.Carro;


public class CarroViewHolder extends RecyclerView.ViewHolder {
    TextView tvModelo;
    public CarroViewHolder(@NonNull View itemView) {
        super(itemView);
        tvModelo = itemView.findViewById(R.id.tv_modelo);
    }

    public void bindData(Carro carro) {
        tvModelo.setText(carro.getModelo());
    }
}
