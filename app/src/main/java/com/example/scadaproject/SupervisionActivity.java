package com.example.scadaproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SupervisionActivity extends AppCompatActivity {

    Button btnActuadores, btnSensores;
    RadioButton rbOn;
    boolean isOn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supervision);

        btnActuadores=findViewById(R.id.btnActuadores);
        btnSensores=findViewById(R.id.btnSensores);
        rbOn=findViewById(R.id.rbOn);

        FirebaseDatabase.getInstance().getReference(MainActivity.PATH_ESTADO).child(MainActivity.PATH_ON).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                isOn=snapshot.getValue(boolean.class);
                rbOn.setChecked(isOn);
                if(isOn){
                    btnActuadores.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            startActivity(new Intent(SupervisionActivity.this, SupervisionActuadoresActivity.class));
                        }
                    });

                    btnSensores.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            startActivity(new Intent(SupervisionActivity.this, SupervisionSensoresActivity.class));
                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}