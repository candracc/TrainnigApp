package com.example.trainnigapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Dia_entrenamiento extends AppCompatActivity {
    TextView textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dia_entrenamiento);
        Bundle bundle = getIntent().getExtras();
        if(bundle == null){
            Toast.makeText(this,"Vacioo",Toast.LENGTH_LONG).show();
        }
        else {
            String valor_recibido = bundle.getString("valoredittext");
            //Agrega valor a TextView.
            textview = findViewById(R.id.textView2);
            textview.setText(valor_recibido);
        }
    }
}