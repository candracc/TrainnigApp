package com.example.trainnigapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Grid_Opciones extends AppCompatActivity {
    private List<String> opciones;
    private GridView grid_opciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_opciones);
         grid_opciones =(GridView) findViewById(R.id.grid_opciones);
         opciones = new ArrayList<String>();
         opciones.add("HORARIOS");
         opciones.add("PLAN DE ENTRENAMIENTO");
         opciones.add("PLAN DE ALIMENTACIÓN");
         opciones.add("RUTINAS");
         opciones.add("CONFIGURACIÓN");

       grid_opciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            //   Toast.makeText(Grid_Opciones.this,"Clicked:"+opciones.get(position),Toast.LENGTH_LONG).show();
               if(position==0){
                   Toast.makeText(Grid_Opciones.this,"SI",Toast.LENGTH_LONG).show();
                   Intent intentReg = new Intent(Grid_Opciones.this, MainActivity.class);
                   Grid_Opciones.this.startActivity(intentReg);
               }
           }
       });

         //Enlazamos
        MyAdapter  myAdapter = new MyAdapter(this,R.layout.activity_grid_opciones,opciones);
        grid_opciones.setAdapter(myAdapter);

    }
}