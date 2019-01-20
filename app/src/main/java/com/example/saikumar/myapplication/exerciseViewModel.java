package com.example.saikumar.myapplication;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class exerciseViewModel extends AndroidViewModel {

    private databaseManager dbManager;

    private  MutableLiveData<List<exercise>> listMutableLiveData=new MutableLiveData<>();

    public exerciseViewModel(@NonNull Application application, String tableName) {
        super(application);

       dbManager = new databaseManager(application,tableName);
    }

    public MutableLiveData<List<exercise>> getListMutableLiveData() {
        if(listMutableLiveData==null) {
            listMutableLiveData = new MutableLiveData<>();

            loadData();
        }
        return listMutableLiveData;
    }

    public List<exercise> loadData(){

        List<exercise> newList = new ArrayList<>();
        dbManager=dbManager.open();
        Cursor cursor = dbManager.fetch();
        if(cursor!=null) {
            while (cursor.moveToNext()) {
                int ID = cursor.getColumnIndex(exerciseDatabaseHelper._id);
                int nameExerciseID = cursor.getColumnIndex(exerciseDatabaseHelper.exercise_name);
                int setsExerciseID = cursor.getColumnIndex(exerciseDatabaseHelper.sets);
                int minId = cursor.getColumnIndex(exerciseDatabaseHelper.min);
                int maxId = cursor.getColumnIndex(exerciseDatabaseHelper.max);

                newList.add(new exercise(cursor.getLong(ID), cursor.getString(nameExerciseID), cursor.getInt(setsExerciseID), cursor.getInt(minId), cursor.getInt(maxId)));
            }
            cursor.close();
        }

        dbManager.close();

        for(int i=0;i<newList.size();i++){
            Log.d("ID: ",String.valueOf(newList.get(i).id));
            Log.d("ID: ",String.valueOf(newList.get(i).excerciseName));
        }
        listMutableLiveData.setValue(newList);

        return newList;
    }

    public List<exercise> addData(String name,int sets,int min,int max){

        dbManager=dbManager.open();
        long id = dbManager.insert(name, sets, min, max);
        dbManager.close();

        List<exercise> newList ;
        List<exercise> clone;
        if(listMutableLiveData!=null)
            newList = listMutableLiveData.getValue();
        else
            newList=null;

        if(newList==null){
            clone = new ArrayList<>();
        }else{
            clone = new ArrayList<>(newList.size());
            for(int i=0;i<newList.size();i++){
                clone.add(newList.get(i));
            }
        }

        clone.add(new exercise(id,name,sets,min,max));

        listMutableLiveData.setValue(clone);
        newList=listMutableLiveData.getValue();
        for(int i=0;i<newList.size();i++){
            Log.d("ID: ",String.valueOf(newList.get(i).id));
            Log.d("ID: ",String.valueOf(newList.get(i).excerciseName));
        }
        return clone;
    }

    public List<exercise> updateData(long id,String name,int sets,int min,int max){

        dbManager=dbManager.open();
        dbManager.update(id,name, sets, min, max);
        dbManager.close();

        List<exercise> newList ;
        List<exercise> clone;
        if(listMutableLiveData!=null)
            newList = listMutableLiveData.getValue();
        else
            newList=null;

        if(newList==null){
            clone = new ArrayList<>();
        }else{
            clone = new ArrayList<>(newList.size());
            for(int i=0;i<newList.size();i++){
                clone.add(newList.get(i));
            }
            for(int i=0;i<newList.size();i++){
                Log.d(String.valueOf(i),String.valueOf(clone.get(i).id));
                if(clone.get(i).id==id){
                    Log.d("MATCHED ID: ",String.valueOf(clone.get(i).id));
                    Log.d("REQ ID: ",String.valueOf(id));
                    clone.get(i).excerciseName=name;
                    clone.get(i).sets=sets;
                    clone.get(i).minWeight = min;
                    clone.get(i).maxWeight=max;
                    Log.d("NAME: ",name);
                    break;
                }
            }
        }



        listMutableLiveData.setValue(clone);

        return clone;
    }

    public void removeData(long id){
        dbManager=dbManager.open();
        dbManager.delete(id);
        dbManager.close();

        List<exercise> newList = listMutableLiveData.getValue();
        int idToBeDeleted=-1;
        for(int i=0;i<newList.size();i++){
                exercise temp = newList.get(i);
                if(temp.id==id) {
                    idToBeDeleted = i;
                    break;
                }
        }
        if(idToBeDeleted!=-1) {
            newList.remove(idToBeDeleted);
            listMutableLiveData.setValue(newList);
        }
    }
}
