package com.example.saikumar.myapplication;

import android.annotation.TargetApi;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class addIntoList extends AppCompatActivity {

    public static final String EXTRA_ID = "com.example.saikumar.myapplication.EXTRA_ID";
    public static final String EXTRA_NAME ="com.example.saikumar.myapplication.EXTRA_NAME";
    public static final String EXTRA_SETS ="com.example.saikumar.myapplication.EXTRA_SETS";
    public static final String EXTRA_MINWT ="com.example.saikumar.myapplication.EXTRA_MINWT";
    public static final String EXTRA_MAXWT ="com.example.saikumar.myapplication.EXTRA_MAXWT";


    Intent intent;
    long id;
    String name;
    int sets,minwt,maxwt;
    TextView textExerciseName ;
    TextView textSets ;
    TextView textMinWeight ;
    TextView textMaxWeight ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_list);

        textExerciseName = findViewById(R.id.NAME);
         textSets = findViewById(R.id.SETS);
         textMinWeight = findViewById(R.id.MINWT);
         textMaxWeight = findViewById(R.id.MAXWT);
        intent = getIntent();
        if(intent.hasExtra(EXTRA_ID)){
            setTitle("Edit exercise details");
            id = intent.getLongExtra(EXTRA_ID,-1);
            name = intent.getStringExtra(EXTRA_NAME);
            sets = intent.getIntExtra(EXTRA_SETS,1);
            minwt = intent.getIntExtra(EXTRA_MINWT,1);
            maxwt = intent.getIntExtra(EXTRA_MAXWT,1);

            textExerciseName.setText(name);
            textSets.setText(String.valueOf(sets));
            textMinWeight.setText(String.valueOf(minwt));
            textMaxWeight.setText(String.valueOf(maxwt));
        }else{
            setTitle("Add exercise");
        }
    }

    @Override
    @TargetApi(18)
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = new MenuInflater(getApplicationContext());
        inflater.inflate(R.menu.optionsmenu,menu);
        return true;
    }

    public void saveExercise(){

        String name = textExerciseName.getText().toString();
        int sets = 0;
        int minwt = 0;
        int maxwt = 0;

        String setsTargeted = String.valueOf(textSets.getText()).trim().replaceAll(" ", "");
        try {
            sets = Integer.parseInt(setsTargeted);
        } catch (NumberFormatException e) {
            Log.d("Exception: ", "Invalid input");

        }

        String MinWeight = String.valueOf(textMinWeight.getText()).trim().replaceAll(" ", "");
        try {
            minwt = Integer.parseInt(MinWeight);
        } catch (NumberFormatException e) {
            Log.d("Exception: ", "Invalid input");

        }

        String MaxWeight = String.valueOf(textMaxWeight.getText()).trim().replaceAll(" ", "");
        try {
            maxwt = Integer.parseInt(MaxWeight);
        } catch (NumberFormatException e) {
            Log.d("Exception: ", "Invalid input");

        }

        if (name.isEmpty() || setsTargeted.isEmpty() || MinWeight.isEmpty() || MaxWeight.isEmpty()) {
            Toast.makeText(this, exerciseList.dayNumber, Toast.LENGTH_LONG).show();
        }


        Intent intent = new Intent();
        if(id!=-1){
            intent.putExtra(EXTRA_ID,id);
            Log.d("Passed ID: ",String.valueOf(id));
        }
        intent.putExtra(EXTRA_NAME,name);
        intent.putExtra(EXTRA_SETS,sets);
        intent.putExtra(EXTRA_MINWT,minwt);
        intent.putExtra(EXTRA_MAXWT,maxwt);

        setResult(RESULT_OK,intent);
        finish();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.add:
                saveExercise();
                break;
        }


        return true;
    }
}
