package com.example.paisesycapitalesconsultas;

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

import com.example.paisesycapitalesconsultas.db.DbHelper;

public class MainActivity extends AppCompatActivity {


    EditText txtcapital,txtpais;
    TextView dalacapital , daelpais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtcapital = findViewById(R.id.capitalEscrita);
        txtpais = findViewById(R.id.paisEscrito);
        dalacapital = findViewById(R.id.dalacapital);
        daelpais = findViewById(R.id.daelpais);

    }
    public void buscarcapi(View view){
        DbHelper dbHelper = new DbHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String pais = txtpais.getText().toString();

        if(!pais.isEmpty()){
            Cursor fila =db.rawQuery
                    ("select Pais , Capital from t_paises where Pais ='"+ pais +"'", null);
            if(fila.moveToFirst()){

                dalacapital.setText(fila.getString(1));

                db.close();
            }  else{
                Toast.makeText(this, "no existe el pais", Toast.LENGTH_LONG).show();
                Intent i = new Intent(this,Activity3.class);
                startActivity(i);
                db.close();
            }


        }
        else{Toast.makeText(this,"debes introducir el nombre del pais",
                Toast.LENGTH_LONG).show();}



    }

    public void buscarpais(View view){
        DbHelper dbHelper = new DbHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String capi = txtcapital.getText().toString();

        if(!capi.isEmpty()){
            Cursor fila =db.rawQuery
                    ("select Pais , Capital from t_paises where Capital ='"+ capi +"'", null);
            if(fila.moveToFirst()){

                daelpais.setText(fila.getString(0));

                db.close();
            }  else{
                Toast.makeText(this, "no existe la capital", Toast.LENGTH_LONG).show();
                Intent i = new Intent(this,Activity2.class);
                startActivity(i);
                db.close();
            }


        }
        else{Toast.makeText(this,"debes introducir el nombre del pais",
                Toast.LENGTH_LONG).show();}



    }



}

