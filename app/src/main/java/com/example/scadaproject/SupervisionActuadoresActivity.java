package com.example.scadaproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SupervisionActuadoresActivity extends AppCompatActivity {

    RadioButton rbAbrir_piso, rbBanda1, rbBanda2, rbClamp, rbElevador_Moviendo, rbExit_Conveyor, rbLoad_Pallet, rbPallet_Feeder, rbPush, rbRotador;
    Actuadores actuadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supervision_actuadores);

        rbAbrir_piso=findViewById(R.id.rbAbrir_piso);
        rbBanda1=findViewById(R.id.rbBanda1);
        rbBanda2=findViewById(R.id.rbBanda2);
        rbClamp=findViewById(R.id.rbClamp);
        rbElevador_Moviendo=findViewById(R.id.rbElevador_Moviendo);
        rbExit_Conveyor=findViewById(R.id.rbExit_Conveyor);
        rbLoad_Pallet=findViewById(R.id.rbLoad_Pallet);
        rbPallet_Feeder=findViewById(R.id.rbPallet_Feeder);
        rbPush=findViewById(R.id.rbPush);
        rbRotador=findViewById(R.id.rbRotador);

        FirebaseDatabase.getInstance().getReference(MainActivity.PATH_SUPERVISION).child(MainActivity.PATH_ACTUADORES).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                actuadores=snapshot.getValue(Actuadores.class);
                rbAbrir_piso.setChecked(actuadores.isAbrir_piso());
                rbBanda1.setChecked(actuadores.isBanda1());
                rbBanda2.setChecked(actuadores.isBanda2());
                rbClamp.setChecked(actuadores.isClamp());
                rbElevador_Moviendo.setChecked(actuadores.isElevador_Moviendo());
                rbExit_Conveyor.setChecked(actuadores.isExit_Conveyor());
                rbLoad_Pallet.setChecked(actuadores.isLoad_Pallet());
                rbPallet_Feeder.setChecked(actuadores.isPallet_Feeder());
                rbPush.setChecked(actuadores.isPush());
                rbRotador.setChecked(actuadores.isRotador());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}