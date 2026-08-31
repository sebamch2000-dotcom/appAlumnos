package com.senati.appalumnos.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    //definimos variables con una variables vamos a controlar los cambios en la base de datos
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "senati.db";
    private static final String TABLE_CONTACTOS = "alumnos";

    //Constructor DbHelper
    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    //Evento se va crear : para crear la base de datos
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // COLOCAMOS EL SCRIPT SQL
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_CONTACTOS + " (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL," +
                "telefono TEXT NOT NULL," +
                "correo_electronico TEXT)");
    }

    // Evento se ejecuta cuando cambia la version de la base de datos.
    // cuando cambio la version a 2 ejem: DATABASE_VERSION=2 se ejecuta el metodo
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // primero nos elimine la tabla que tenemos y luego que agrege una nueva tabla
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_CONTACTOS);
        onCreate(sqLiteDatabase);
    }
}
