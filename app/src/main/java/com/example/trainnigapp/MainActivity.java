package com.example.trainnigapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    TextView tv_crearusuario;
    Button button_registro;
    EditText et_usuario , et_password;
    private RequestQueue cola;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_crearusuario = findViewById(R.id.tv_crearusuario);
        button_registro = findViewById(R.id.button_ingreso);
        et_usuario=findViewById(R.id.et_usuario);
        et_password= findViewById(R.id.et_password);


     /*   button_registro.setOnClickListener(new View.OnClickListener() { //abrir ventana Ingreso
            @Override
            public void onClick(View v) {
                Intent intentReg = new Intent(MainActivity.this, Inicio.class);
                MainActivity.this.startActivity(intentReg);
            }
        });


        tv_crearusuario.setOnClickListener(new View.OnClickListener() { //abrir ventana crear usuario
            @Override
            public void onClick(View v) {
                Intent intentReg = new Intent(MainActivity.this, Registrar.class);
                MainActivity.this.startActivity(intentReg);
            }
        });
        //Prueba de devolver valor de la ventana Registrar
        Bundle bundle = getIntent().getExtras();

        if(bundle == null){
       //     Toast.makeText(this,"VACIO",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this,"LLENO",Toast.LENGTH_LONG).show();
            String valor_recibido = bundle.getString("usuario");
            //Agrega valor a TextView.
            et_usuario = findViewById(R.id.et_usuario);
            et_usuario.setText(valor_recibido);

        }*/
    }

    public void Ingresar(View view) {
        Toast.makeText(this,et_usuario.getText().toString(),Toast.LENGTH_LONG).show();
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getApplicationContext(), "Trainning", null, 1 );
        SQLiteDatabase Trainning = admin.getWritableDatabase();

        String s_usuario =et_usuario.getText().toString();
        String s_password = et_password.getText().toString();

        if (!s_usuario.isEmpty() && !s_password.isEmpty()){
            Cursor fila = Trainning.rawQuery("select password , descripcion,id,nombres,apellidop from usuario where descripcion = '" + s_usuario +"'", null);

            if (fila.moveToFirst()){
                System.out.println("fila"+fila.getString(2)+"-"+fila.getString(3));
                if(s_password.equals(fila.getString(0))){
                    Trainning.close();

                    Intent login = new Intent(MainActivity.this, Inicio.class);
                    login.putExtra("usuario", "bienvenido "+fila.getString(3)+" "+ fila.getString(4));
                    startActivity(login);
                    finish();
                }else{
                    Toast.makeText(this, "Contraseña incorrecta", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(getApplicationContext(), "No existe el Correo: "+s_usuario, Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(getApplicationContext(), "Debes introducir el Correo y Contraseña", Toast.LENGTH_SHORT).show();
        }

    }

    public void Registrar (View view){
        Intent login = new Intent(this, Registrar.class);
        startActivity(login);
    }

    public void ListarUsuarios(View view){
    String url = "https://unaoojf45renrcmqe2hcs2amcm0rxwvn.lambda-url.us-east-1.on.aws/";
        // Instantiate the RequestQueue.
        RequestQueue cola = Volley.newRequestQueue(this);
        RequestQueue queue = Volley.newRequestQueue(this);
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                       // delete backslashes ( \ ) :
                        //response = response.replaceAll("[\\\\]{1}[\"]{1}","\"");
                        //delete first and last double quotation ( " ) :
                       // response = response.substring(response.indexOf("{"),response.lastIndexOf("}")+1);
                      // try {
                           //   JSONObject json = new JSONObject(response);
                           //JSONArray array = (JSONArray)json.get("usuario");
                         //  for(int i = 0; i < array.length(); i++){
                               //JSONObject json1 = (JSONObject)array.get(i);
                               et_usuario.setText(response);//getString("sexo"));




                          // et_password.setText(json.getString("nombre"));
                       // } catch (JSONException e) {
                         //   e.printStackTrace();
                      //  }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,"HORROR",Toast.LENGTH_SHORT).show();
            }
        });
        // Add the request to the RequestQueue.
        queue.add(stringRequest);
     /*  String url = "https://xbh72gp3hk.execute-api.us-east-2.amazonaws.com/DESA/crearusuario";
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest jsObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    JSONArray jsonArray = response.getJSONArray("arreglo");
                    JSONObject jsonObject = jsonArray.getJSONObject(0); //0 indica el primer objeto dentro del array.
                    et_usuario.setText(jsonObject.getString("correo")); //Agrega valor de character a TextView.


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(MainActivity.this,"error"+ error.getMessage(),Toast.LENGTH_SHORT).show();

                    }
                });
        requestQueue.add(jsObjectRequest);*/
    }
}

