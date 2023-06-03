package com.example.trainnigapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Inicio extends AppCompatActivity {
    Button b_planentrenamiento;
    Button b_planalimentacion;
    Button b_perfil;
    TextView tv_bienvenida;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        b_planentrenamiento = findViewById(R.id.b_planentrenamiento);
        b_planentrenamiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentReg = new Intent(Inicio.this, Plan_Entrenamiento.class);
                Inicio.this.startActivity(intentReg);
            }
        });

        b_planalimentacion = findViewById(R.id.b_planalimentacion);
        b_planalimentacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentReg = new Intent(Inicio.this, Plan_alimentacion.class);
                Inicio.this.startActivity(intentReg);
            }
        });

        b_perfil = findViewById(R.id.b_perfil);
        b_perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentReg = new Intent(Inicio.this, Perfil.class);
                Inicio.this.startActivity(intentReg);
            }
        });

        //Prueba de devolver valor de la ventana Registrar
        Bundle bundle = getIntent().getExtras();

        if(bundle == null){
            //     Toast.makeText(this,"VACIO",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this,"HOLiiii",Toast.LENGTH_LONG).show();
            String valor_recibido = bundle.getString("usuario");
            //Agrega valor a TextView.
            tv_bienvenida = findViewById(R.id.tv_bienvenida);
            tv_bienvenida.setText(valor_recibido);

        }
    }

}