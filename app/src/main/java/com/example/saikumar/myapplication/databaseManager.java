package com.example.saikumar.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class databaseManager {

    private Context context;
    public SQLiteDatabase sqldb;
    private exerciseDatabaseHelper dbHelper;
    private String Table_Name;

    public databaseManager(Context c, String s){
        context =c;
        Table_Name=s;

    }

    public databaseManager open(){

        dbHelper = new exerciseDatabaseHelper(context,Table_Name,null,1);
        sqldb = dbHelper.getWritableDatabase();
        return this;
    }

    public void close(){
        dbHelper.close();
    }

    public long insert(String name,int reps,int min,int max){
        ContentValues contentValues = new ContentValues();
        contentValues.put(exerciseDatabaseHelper.exercise_name,name);
        contentValues.put(exerciseDatabaseHelper.sets,reps);
        contentValues.put(exerciseDatabaseHelper.min,min);
        contentValues.put(exerciseDatabaseHelper.max,max);
        return sqldb.insert(Table_Name,null,contentValues);
    }

    public Cursor fetch(){
        String columns[] = {exerciseDatabaseHelper._id, exerciseDatabaseHelper.exercise_name, exerciseDatabaseHelper.sets, exerciseDatabaseHelper.min, exerciseDatabaseHelper.max};
        Cursor cursor  = sqldb.rawQuery("select DISTINCT tbl_name from sqlite_master where tbl_name = '"
                + Table_Name + "'", null);
        if(cursor.getCount()>0){
            cursor = sqldb.query(Table_Name,columns,null,null,null,null,null);
        }
        else
            cursor=null;

        return cursor;
    }

    public void update(long _id,String name,int reps,int min,int max){
        ContentValues contentValues = new ContentValues();
        contentValues.put(exerciseDatabaseHelper.exercise_name,name);
        contentValues.put(exerciseDatabaseHelper.sets,reps);
        contentValues.put(exerciseDatabaseHelper.min,min);
        contentValues.put(exerciseDatabaseHelper.max,max);
        int i= sqldb.update(Table_Name,contentValues, exerciseDatabaseHelper._id+" = "+_id,null);
        Log.d("Rows affected: ",String.valueOf(_id));
    }

    public void delete(long _id){
        sqldb.delete(Table_Name, exerciseDatabaseHelper._id+" = "+_id,null);
    }

}
