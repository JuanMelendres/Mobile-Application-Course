package com.itesm.localstorage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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

    public DBHelper(Context context){
        super(context, DB_FILE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE + "(" +
                FIELD_ID + " INTEGER PRIMARY KEY, " +
                FIELD_NAME + " TEXT, " +
                FIELD_GRADE + " INTEGER)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // si cambiamos de version luego
        // prepared statements
        String query = "DROP TABLE IF EXISTS " + TABLE;
        String[] params = {TABLE};
        db.execSQL(query, params);
    }

    public void save(String nombre, int calificacion){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues valores = new ContentValues();

        valores.put(FIELD_NAME, nombre);
        valores.put(FIELD_GRADE, calificacion);

        // tabla, argumentos
        db.insert(TABLE, null, valores);
    }

    public int delete(String nombre){
        SQLiteDatabase db = getWritableDatabase();
        String clause = FIELD_NAME + " = ?";
        String[] args = {nombre};
        return db.delete(TABLE, clause, args);
    }

    public int find(String nombre){
        SQLiteDatabase db = getReadableDatabase();
        String filtrito = FIELD_NAME + " = ?";
        String[] args = {nombre};

        Cursor c = db.query(TABLE, null, filtrito, args, null, null, null);
        int result = -1;

        if(c.moveToFirst()) { // se puede iterar en un conjunto de resultados c.moveToNext()
            result = c.getInt(2);
        }

        return result;
    }
}
