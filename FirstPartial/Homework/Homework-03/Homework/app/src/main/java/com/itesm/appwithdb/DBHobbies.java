package com.itesm.appwithdb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHobbies extends SQLiteOpenHelper {

    private static final String DB_FILE = "HobbiesDB.db";
    private static final String TABLE = "HOBBIES";
    private static final String FIELD_ID = "id";
    private static final String FIELD_FRIEND = "friends";
    private static final String FIELD_HOBBY = "hobby";

    public DBHobbies(Context context){
        super(context,DB_FILE,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE + "(" +
                FIELD_ID + " INTEGER PRIMARY KEY, " +
                FIELD_FRIEND + " TEXT, " +
                FIELD_HOBBY + " TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS " + TABLE;
        String[] params = {TABLE};
        db.execSQL(query, params);
    }

    public void save(String friendName, String hobby) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(FIELD_FRIEND, friendName);
        values.put(FIELD_HOBBY, hobby);
        db.insert(TABLE, null, values);
    }

    public int delete(String friendName) {
        SQLiteDatabase db = getWritableDatabase();
        String clause = FIELD_FRIEND + " = ?";
        String[] args = {friendName};
        return db.delete(TABLE, clause, args);
    }

    public String find(String friendName) {
        SQLiteDatabase db = getReadableDatabase();
        String clause = FIELD_FRIEND + " = ?";
        String[] args = {friendName};

        Cursor c = db.query(TABLE, null, clause, args, null, null, null);
        String res = "N/A";

        if (c.moveToFirst()) {
            res = c.getString(2);
        }

        return res;
    }


}
