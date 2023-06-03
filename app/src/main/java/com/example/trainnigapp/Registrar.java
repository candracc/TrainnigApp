package com.example.trainnigapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Registrar extends AppCompatActivity {
    Button b_crearusuario;
    EditText et_nombres, et_apellidop, et_usuario, et_password, et_correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        et_nombres =findViewById(R.id.et_nombres);
        et_apellidop =findViewById(R.id.et_apellidop);
        et_usuario =findViewById(R.id.et_usuario);
        et_password =findViewById(R.id.et_password);
        et_correo= findViewById(R.id.et_correo);

     /*   b_crearusuario.setOnClickListener(new View.OnClickListener() { //abrir ventana crear usuario
            @Override
            public void onClick(View v) {
                Intent intentReg = new Intent(Registrar.this, MainActivity.class);
                intentReg.putExtra("usuario",et_usuario.getText().toString());
                Registrar.this.startActivity(intentReg);
            }
        });*/
    }
    public void Registrar (View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Trainning", null, 1);
        SQLiteDatabase Trainning = admin.getWritableDatabase();

        String s_nombres = et_nombres.getText().toString();
        String s_apellidop = et_apellidop.getText().toString();
        String s_correo = et_correo.getText().toString();
        String s_usuario = et_usuario.getText().toString();
        String s_password = et_password.getText().toString();


        if (!s_nombres.isEmpty() && !s_apellidop.isEmpty()&& !s_correo.isEmpty()&& !s_usuario.isEmpty()&& !s_password.isEmpty()) {
            ContentValues registro = new ContentValues();
           // registro.put("id",);
            registro.put("nombres", s_nombres);
            registro.put("apellidop", s_apellidop);
            registro.put("correo", s_correo);
            registro.put("descripcion", s_usuario);
            registro.put("password", s_password);

            Trainning.insert("usuario", null, registro);
            Trainning.close();

            Toast.makeText(getApplicationContext(),"Registro Exitoso",Toast.LENGTH_LONG).show();

            Intent login = new Intent(Registrar.this, MainActivity.class);
            startActivity(login);

        } else {
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

}