package com.example.paisesycapitalesconsultas.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class Dbpaises extends DbHelper {


    Context context;

    public Dbpaises(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarpais(String pais, String capital){
        long id = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("Pais", pais);
            values.put("Capital", capital);
            id = db.insert(TABLE_PAISES, null, values);
        }catch (Exception ex){
            ex.toString();
        }
        return id;
    }
}
