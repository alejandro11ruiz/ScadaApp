package com.example.scadaproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HistorialActivity extends AppCompatActivity {

    RecyclerView listaDeDatos;
    Historial historial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);

        listaDeDatos =findViewById(R.id.rvLista);
        listaDeDatos.setLayoutManager(new LinearLayoutManager(this));

        FirebaseDatabase.getInstance().getReference(MainActivity.PATH_HISTORIAL).child(MainActivity.PATH_DIA).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                historial = llenarHistorial(snapshot);
                historial.filtrar();
                ListaAdapter adapter = new ListaAdapter(historial.getValue(), historial.getDate());
                listaDeDatos.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private Historial llenarHistorial(DataSnapshot snapshot){
        Historial hist = new Historial();
        ArrayList<Boolean> listVal= new ArrayList<>();
        ArrayList<String> listDat= new ArrayList<>();
        Iterable<DataSnapshot> dataValue = snapshot.child(MainActivity.PATH_VALUE).getChildren();
        for (DataSnapshot value : dataValue) {
            boolean val = value.getValue(Boolean.class);
            listVal.add(val);
            }
        Iterable<DataSnapshot> dataDate = snapshot.child(MainActivity.PATH_DATE).getChildren();
        for (DataSnapshot date : dataDate) {
            String dat = date.getValue(String.class);
            listDat.add(dat);
        }
        hist.setValue(listVal);
        hist.setDate(listDat);
        return hist;
    }

}