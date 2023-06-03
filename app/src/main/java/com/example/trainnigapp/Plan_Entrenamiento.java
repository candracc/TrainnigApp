package com.example.trainnigapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Plan_Entrenamiento extends AppCompatActivity {
    Button b_dia1;
    Button b_dia2;
    Button b_dia3;
    Button b_dia4;
    Button b_dia5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planentrenamiento);
        b_dia1=findViewById(R.id.b_dia1);
        b_dia1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentReg = new Intent(Plan_Entrenamiento.this, Dia_entrenamiento.class);
                //intentReg.putExtra("dia","dia1");
                intentReg.putExtra("valoredittext", b_dia1.getText());
                Plan_Entrenamiento.this.startActivity(intentReg);

            }
        });

        b_dia2=findViewById(R.id.b_dia2);
        b_dia2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentReg = new Intent(Plan_Entrenamiento.this, Dia_entrenamiento.class);
                intentReg.putExtra("valoredittext", b_dia2.getText());
                Plan_Entrenamiento.this.startActivity(intentReg);
            }
        });

        b_dia3=findViewById(R.id.b_dia3);
        b_dia3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentReg = new Intent(Plan_Entrenamiento.this, Dia_entrenamiento.class);
                intentReg.putExtra("valoredittext", b_dia3.getText());
                Plan_Entrenamiento.this.startActivity(intentReg);
            }
        });


        b_dia4=findViewById(R.id.b_dia4);
        b_dia4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentReg = new Intent(Plan_Entrenamiento.this, Dia_entrenamiento.class);
                intentReg.putExtra("valoredittext", b_dia4.getText());
                Plan_Entrenamiento.this.startActivity(intentReg);
            }
        });


        b_dia5=findViewById(R.id.b_dia5);
        b_dia5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentReg = new Intent(Plan_Entrenamiento.this, Dia_entrenamiento.class);
                intentReg.putExtra("valoredittext", b_dia5.getText());
                Plan_Entrenamiento.this.startActivity(intentReg);
            }
        });
    }
}