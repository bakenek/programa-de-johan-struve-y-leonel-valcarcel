package com.example.paisesycapitalesconsultas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.paisesycapitalesconsultas.db.DbHelper;
import com.example.paisesycapitalesconsultas.db.Dbpaises;

public class Activity2 extends AppCompatActivity {

    EditText txtpais,txtcapital;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        txtcapital = findViewById(R.id.txtcapital);
        txtpais = findViewById(R.id.txtpais);


    }
    public void btnguardar(View view){

        String val1 = txtcapital.getText().toString();
        String val2 = txtpais.getText().toString();

        if(val1.isEmpty() || val2.isEmpty()){
            Toast.makeText(this, "Debes rellenar ambos campos", Toast.LENGTH_LONG).show();
        }
        else {
            Dbpaises dbpaises = new Dbpaises(Activity2.this);
            long id = dbpaises.insertarpais(txtpais.getText().toString(), txtcapital.getText().toString());

            if (id > 0) {
                Toast.makeText(Activity2.this, "se guardo en la base", Toast.LENGTH_LONG).show();
                limpiar();
            } else {
                Toast.makeText(Activity2.this, "error al guardar", Toast.LENGTH_LONG).show();
            }


        }
        }

    private void limpiar(){
        txtpais.setText("");
        txtcapital.setText("");
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i); }

   /* public void buscar(View view){
        DbHelper dbHelper = new DbHelper(Activity2.this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String pais = txtpais.getText().toString();

        if(!pais.isEmpty()){
            Cursor fila =db.rawQuery
                    ("select Pais , Capital from t_paises where Pais ='"+ pais +"'", null);
            if(fila.moveToFirst()){

                txtcapital.setText(fila.getString(1));

                db.close();
            }  else{
                Toast.makeText(Activity2.this, "no existe el pais", Toast.LENGTH_LONG).show();
                Intent i = new Intent(this,Activity3.class);
                startActivity(i);
                db.close();
            }


        }
        else{Toast.makeText(this,"debes introducir el nombre del pais",
                Toast.LENGTH_LONG).show();}



    }*/

}