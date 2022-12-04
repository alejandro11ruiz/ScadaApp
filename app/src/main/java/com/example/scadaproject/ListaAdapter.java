package com.example.scadaproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListaAdapter extends RecyclerView.Adapter<ListaAdapter.EstadoViewHolder> {
    ArrayList<String> listaDate;
    ArrayList<Boolean> listaValue;

    public ListaAdapter(ArrayList<Boolean> listaValue, ArrayList<String> listaDate){
        this.listaDate=listaDate;
        this.listaValue=listaValue;
    }

    /*
    Importa el layout para la visualizacion de cada objeto individual en el recycler view
    */
    @NonNull
    @Override
    public EstadoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item,null,false);
        return new EstadoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EstadoViewHolder holder, int position) {
        holder.rbValue.setChecked(listaValue.get(position));
        holder.tvDate.setText(listaDate.get(position));
    }

    @Override
    public int getItemCount() {
        return listaValue.size();
    }

    public class EstadoViewHolder extends RecyclerView.ViewHolder {

        RadioButton rbValue;
        TextView tvDate;

        public EstadoViewHolder(@NonNull View itemView) {
            super(itemView);

            rbValue=itemView.findViewById(R.id.rbValue);
            tvDate=itemView.findViewById(R.id.tvDate);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                }
            });

        }
    }
}
