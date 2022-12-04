package com.example.scadaproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SupervisionSensoresActivity extends AppCompatActivity {

    RadioButton rbClamped, rbLimite_Piso, rbPallet_Entry, rbPallet_Loaded, rbPusher_Limit, rbSensor_Cajas;
    Sensores sensores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supervision_sensores);

        rbClamped=findViewById(R.id.rbClamped);
        rbLimite_Piso=findViewById(R.id.rbLimite_Piso);
        rbPallet_Entry=findViewById(R.id.rbPallet_Entry);
        rbPallet_Loaded=findViewById(R.id.rbPallet_Loaded);
        rbPusher_Limit=findViewById(R.id.rbPusher_Limit);
        rbSensor_Cajas=findViewById(R.id.rbSensor_Cajas);

        rbClamped.setClickable(false);
        rbLimite_Piso.setClickable(false);
        rbPallet_Entry.setClickable(false);
        rbPallet_Loaded.setClickable(false);
        rbPusher_Limit.setClickable(false);
        rbSensor_Cajas.setClickable(false);

        FirebaseDatabase.getInstance().getReference(MainActivity.PATH_SUPERVISION).child(MainActivity.PATH_SENSORES).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                sensores=snapshot.getValue(Sensores.class);
                rbClamped.setChecked(sensores.isClamped());
                rbLimite_Piso.setChecked(sensores.isLimite_Piso());
                rbPallet_Entry.setChecked(sensores.isPallet_Entry());
                rbPallet_Loaded.setChecked(sensores.isPallet_Loaded());
                rbPusher_Limit.setChecked(sensores.isPusher_Limit());
                rbSensor_Cajas.setChecked(sensores.isSensor_Cajas());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}