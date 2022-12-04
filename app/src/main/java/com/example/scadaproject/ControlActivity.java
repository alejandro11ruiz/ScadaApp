package com.example.scadaproject;

import androidx.annotation.ColorLong;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ControlActivity extends AppCompatActivity {

    Button btnStart, btnStop;
    Handler handler;
    RadioButton rbOn;
    boolean isOn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);

        btnStart=findViewById(R.id.btnStart);
        btnStop=findViewById(R.id.btnStop);
        rbOn=findViewById(R.id.rbOn);

        FirebaseDatabase.getInstance().getReference(MainActivity.PATH_ESTADO).child(MainActivity.PATH_ON).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                isOn=snapshot.getValue(boolean.class);
                rbOn.setChecked(isOn);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        handler = new Handler();

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isOn) {
                    btnStart.setEnabled(false);
                    btnStart.setClickable(false);
                    btnStop.setEnabled(false);
                    btnStop.setClickable(false);
                    FirebaseDatabase.getInstance().getReference(MainActivity.PATH_CONTROL).child(MainActivity.PATH_START).setValue(true);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            btnStart.setEnabled(true);
                            btnStart.setClickable(true);
                            btnStop.setEnabled(true);
                            btnStop.setClickable(true);
                            FirebaseDatabase.getInstance().getReference(MainActivity.PATH_CONTROL).child(MainActivity.PATH_START).setValue(false);
                        }
                    }, 2000);
                }
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isOn) {
                    btnStop.setEnabled(false);
                    btnStop.setClickable(false);
                    btnStart.setEnabled(false);
                    btnStart.setClickable(false);
                    FirebaseDatabase.getInstance().getReference(MainActivity.PATH_CONTROL).child(MainActivity.PATH_STOP).setValue(true);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            btnStop.setEnabled(true);
                            btnStop.setClickable(true);
                            btnStart.setEnabled(true);
                            btnStart.setClickable(true);
                            FirebaseDatabase.getInstance().getReference(MainActivity.PATH_CONTROL).child(MainActivity.PATH_STOP).setValue(false);
                        }
                    }, 2000);
                }
            }
        });

    }
}