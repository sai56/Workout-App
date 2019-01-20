package com.example.saikumar.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import android.util.Log;

public class exerciseDatabaseHelper extends SQLiteOpenHelper {

    private String TABLE_NAME;
    public final static String _id = "_id";
    public final static String exercise_name ="exercise_name";
    public final static String sets = "sets";
    public final static String min ="min";
    public final static String max ="max";
    private final  String CREATE_TABLE;


    public exerciseDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {


        super(context, name, factory, version);

        TABLE_NAME = name;

        CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ("+_id+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                +exercise_name+" TEXT NOT NULL, "+sets+" INTEGER NOT NULL, "+min+" INTEGER NOT NULL, "+max+" INTEGER NOT NULL);";


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

}
