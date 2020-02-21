package com.itesm.localstorage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import org.w3c.dom.Text;

/*
    1era estrategia - utilizar una base de datos local
    sqlite ?
    manejador de base de datos relacionales
    se guarda en un archivo local
    como es relacional utiliza queries

*/

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_FILE = "Database.db";
    private static final String TABLE = "Estudiantes";
    private static final String FIELD_ID = "id";
    private static final String FIELD_NAME = "nombre";
    private static final String FIELD_GRADE = "calificacion";

    public DBHelper(Context context) {
        super(context, DB_FILE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE + "(" +
                FIELD_ID+"INTEGER PRIMARY KEY, " +
                FIELD_NAME+"TEXT, " +
                FIELD_GRADE+ "INTEGER)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // si cambiamos de version luego
        // prepared statements
        String query = "DROP TABLE IF EXISTS ?";
        String[] params = {TABLE};
        db.execSQL(query, params);
    }
}
