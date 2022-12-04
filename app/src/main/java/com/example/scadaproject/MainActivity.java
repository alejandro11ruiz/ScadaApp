package com.example.scadaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    public static final String PATH_SUPERVISION = "Supervision";
    public static final String PATH_ACTUADORES = "Actuadores";
    public static final String PATH_SENSORES = "Sensores";
    public static final String PATH_CONTROL = "Control";
    public static final String PATH_START = "Start";
    public static final String PATH_STOP = "Stop";
    public static final String PATH_ESTADO = "Estado";
    public static final String PATH_ON = "On";
    public static final String PATH_HISTORIAL = "Historial";
    public static final String PATH_DIA = "Dia_1";
    public static final String PATH_VALUE = "Value";
    public static final String PATH_DATE= "Date";

    Button btnSupervision, btnControl, btnHistorial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSupervision=findViewById(R.id.btnSupervision);
        btnControl=findViewById(R.id.btnControl);
        btnHistorial=findViewById(R.id.btnHistorial);

        btnSupervision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SupervisionActivity.class));
            }
        });

        btnControl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ControlActivity.class));
            }
        });

        btnHistorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, HistorialActivity.class));
            }
        });

    }


}