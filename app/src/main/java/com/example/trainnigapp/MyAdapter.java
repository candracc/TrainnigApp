package com.example.trainnigapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<String> opciones;

    public MyAdapter(Context context, int layout, List<String> opciones){
        this.context=context;
        this.layout=layout;
        this.opciones=opciones;
    }
    @Override
    public int getCount() { return this.opciones.size();
    }

    @Override
    public Object getItem(int position) {
        return this.opciones.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        //Copiamos la vista
        View v = convertView;
        //Inflamos la vista que nos llego con nuestro layout personalizado
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        v=layoutInflater.inflate(R.layout.formato_opciones,null);

        //Nos traemos el valor actual dependiente de la posición
        String currentName =opciones.get(position);
       // currentName = (String) getItem(position)
        //Referenciamos el elemento a modificar y lo rellenamos
        TextView textView =(TextView) v.findViewById(R.id.textView7);
        textView.setText(currentName);
        return v;
    }
}
