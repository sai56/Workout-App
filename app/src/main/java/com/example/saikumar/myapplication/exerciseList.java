package com.example.saikumar.myapplication;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.ClipData;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.List;

public class exerciseList extends AppCompatActivity {


    public static final int REQ_CODE=1;
    public static final int EDIT_REQ_CODE=2;
    public static String dayNumber;
    exerciseViewModel viewModel ;
    RecyclerView recyclerView;
    RelativeLayout relativeLayout;

    exerciseAdapter adapter =new exerciseAdapter();

    @Override
    protected void onCreate(final Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excercise_list);
        Intent intent = getIntent();

        if(intent.hasExtra(Intent.EXTRA_TEXT)){
            dayNumber = intent.getStringExtra(Intent.EXTRA_TEXT);
        }
        else{
            dayNumber = null;
        }

        relativeLayout = findViewById(R.id.emptyView);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        FloatingActionButton fab = findViewById(R.id.floatingButton);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(exerciseList.this, addIntoList.class);
                startActivityForResult(intent,REQ_CODE);

            }
        });

        int day;

        if(dayNumber!=null)
             day = Integer.parseInt(dayNumber);
        else
            day =0;

        switch(day){
            case 1:

                ViewModelProvider.Factory factory = new ViewModelProvider.Factory() {
                    @NonNull
                    @Override
                    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {


                        return (T) new exerciseViewModel(getApplication(),
                                "Monday");
                    }
                };
                if(isDbPresent("Monday")) {

                    viewModel = ViewModelProviders.of(this, factory).get(exerciseViewModel.class);
                    adapter.setListData(viewModel.loadData());
                    recyclerView.setAdapter(adapter);
                    recyclerView.setVisibility(View.VISIBLE);
                    relativeLayout.setVisibility(View.GONE);
                    Log.d("HEY: ","WHO'S THIS");

                }


                viewModel.getListMutableLiveData().observe(this, new Observer<List<exercise>>() {
                   @Override
                   public void onChanged(@Nullable List<exercise> exercises) {
                       adapter.setListData(exercises);
                      if(exercises.size()==0){
                          recyclerView.setVisibility(View.GONE);
                          relativeLayout.setVisibility(View.VISIBLE);
                      }
                   }
                });

                break;

            case 2:

                ViewModelProvider.Factory factory1 = new ViewModelProvider.Factory() {
                    @NonNull
                    @Override
                    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {


                        return (T) new exerciseViewModel(getApplication(),
                                "Tuesday");
                    }
                };
                if(isDbPresent("Tuesday")) {

                    viewModel = ViewModelProviders.of(this, factory1).get(exerciseViewModel.class);
                    adapter.setListData(viewModel.loadData());
                    recyclerView.setAdapter(adapter);
                    recyclerView.setVisibility(View.VISIBLE);
                    relativeLayout.setVisibility(View.GONE);
                    Log.d("HEY: ","WHO'S THIS");

                }


                viewModel.getListMutableLiveData().observe(this, new Observer<List<exercise>>() {
                    @Override
                    public void onChanged(@Nullable List<exercise> exercises) {
                        adapter.setListData(exercises);
                        if(exercises.size()==0){
                            recyclerView.setVisibility(View.GONE);
                            relativeLayout.setVisibility(View.VISIBLE);
                        }
                    }
                });

                break;
            case 3:
                ViewModelProvider.Factory factory2 = new ViewModelProvider.Factory() {
                    @NonNull
                    @Override
                    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {


                        return (T) new exerciseViewModel(getApplication(),
                                "Wednesday");
                    }
                };
                if(isDbPresent("Wednesday")) {

                    viewModel = ViewModelProviders.of(this, factory2).get(exerciseViewModel.class);
                    adapter.setListData(viewModel.loadData());
                    recyclerView.setAdapter(adapter);
                    recyclerView.setVisibility(View.VISIBLE);
                    relativeLayout.setVisibility(View.GONE);
                    Log.d("HEY: ","WHO'S THIS");

                }


                viewModel.getListMutableLiveData().observe(this, new Observer<List<exercise>>() {
                    @Override
                    public void onChanged(@Nullable List<exercise> exercises) {
                        adapter.setListData(exercises);
                        if(exercises.size()==0){
                            recyclerView.setVisibility(View.GONE);
                            relativeLayout.setVisibility(View.VISIBLE);
                        }
                    }
                });

                break;
            case 4:
                ViewModelProvider.Factory factory3 = new ViewModelProvider.Factory() {
                    @NonNull
                    @Override
                    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {


                        return (T) new exerciseViewModel(getApplication(),
                                "Thursday");
                    }
                };
                if(isDbPresent("Thursday")) {

                    viewModel = ViewModelProviders.of(this, factory3).get(exerciseViewModel.class);
                    adapter.setListData(viewModel.loadData());
                    recyclerView.setAdapter(adapter);
                    recyclerView.setVisibility(View.VISIBLE);
                    relativeLayout.setVisibility(View.GONE);
                    Log.d("HEY: ","WHO'S THIS");

                }


                viewModel.getListMutableLiveData().observe(this, new Observer<List<exercise>>() {
                    @Override
                    public void onChanged(@Nullable List<exercise> exercises) {
                        adapter.setListData(exercises);
                        if(exercises.size()==0){
                            recyclerView.setVisibility(View.GONE);
                            relativeLayout.setVisibility(View.VISIBLE);
                        }
                    }
                });

                break;
            case 5:
                ViewModelProvider.Factory factory4 = new ViewModelProvider.Factory() {
                    @NonNull
                    @Override
                    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {


                        return (T) new exerciseViewModel(getApplication(),
                                "Friday");
                    }
                };
                if(isDbPresent("Friday")) {

                    viewModel = ViewModelProviders.of(this, factory4).get(exerciseViewModel.class);
                    adapter.setListData(viewModel.loadData());
                    recyclerView.setAdapter(adapter);
                    recyclerView.setVisibility(View.VISIBLE);
                    relativeLayout.setVisibility(View.GONE);
                    Log.d("HEY: ","WHO'S THIS");

                }


                viewModel.getListMutableLiveData().observe(this, new Observer<List<exercise>>() {
                    @Override
                    public void onChanged(@Nullable List<exercise> exercises) {
                        adapter.setListData(exercises);
                        if(exercises.size()==0){
                            recyclerView.setVisibility(View.GONE);
                            relativeLayout.setVisibility(View.VISIBLE);
                        }
                    }
                });
                break;
            case 6:
                ViewModelProvider.Factory factory5 = new ViewModelProvider.Factory() {
                    @NonNull
                    @Override
                    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {


                        return (T) new exerciseViewModel(getApplication(),
                                "Saturday");
                    }
                };
                if(isDbPresent("Saturday")) {

                    viewModel = ViewModelProviders.of(this, factory5).get(exerciseViewModel.class);
                    adapter.setListData(viewModel.loadData());
                    recyclerView.setAdapter(adapter);
                    recyclerView.setVisibility(View.VISIBLE);
                    relativeLayout.setVisibility(View.GONE);
                    Log.d("HEY: ","WHO'S THIS");

                }


                viewModel.getListMutableLiveData().observe(this, new Observer<List<exercise>>() {
                    @Override
                    public void onChanged(@Nullable List<exercise> exercises) {
                        adapter.setListData(exercises);
                        if(exercises.size()==0){
                            recyclerView.setVisibility(View.GONE);
                            relativeLayout.setVisibility(View.VISIBLE);
                        }
                    }
                });

                break;
            case 7:
                ViewModelProvider.Factory factory6 = new ViewModelProvider.Factory() {
                    @NonNull
                    @Override
                    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {


                        return (T) new exerciseViewModel(getApplication(),
                                "Sunday");
                    }
                };
                if(isDbPresent("Sunday")) {

                    viewModel = ViewModelProviders.of(this, factory6).get(exerciseViewModel.class);
                    adapter.setListData(viewModel.loadData());
                    recyclerView.setAdapter(adapter);
                    recyclerView.setVisibility(View.VISIBLE);
                    relativeLayout.setVisibility(View.GONE);
                    Log.d("HEY: ","WHO'S THIS");

                }


                viewModel.getListMutableLiveData().observe(this, new Observer<List<exercise>>() {
                    @Override
                    public void onChanged(@Nullable List<exercise> exercises) {
                        adapter.setListData(exercises);
                        if(exercises.size()==0){
                            recyclerView.setVisibility(View.GONE);
                            relativeLayout.setVisibility(View.VISIBLE);
                        }
                    }
                });

                break;
            default:

                break;

        }

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
                viewModel.removeData(adapter.getID(viewHolder.getAdapterPosition()));
            }
        }).attachToRecyclerView(recyclerView);

        adapter.setOnItemClickListener(new exerciseAdapter.onItemClickListener() {
            @Override
            public void onItemClick(exercise Exercise) {
                Intent intent  = new Intent(exerciseList.this,addIntoList.class);
                intent.putExtra(addIntoList.EXTRA_ID,Exercise.id);
                Log.d("Clicked Id: ",String.valueOf(Exercise.id));
                intent.putExtra(addIntoList.EXTRA_NAME,Exercise.excerciseName);
                intent.putExtra(addIntoList.EXTRA_SETS,Exercise.sets);
                intent.putExtra(addIntoList.EXTRA_MINWT,Exercise.minWeight);
                intent.putExtra(addIntoList.EXTRA_MAXWT,Exercise.maxWeight);
                startActivityForResult(intent,EDIT_REQ_CODE);
            }
        });

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        String name;
        long id;
        int sets,minwt,maxwt;
        if(requestCode==REQ_CODE && resultCode==RESULT_OK){

            name = data.getStringExtra(addIntoList.EXTRA_NAME);
            sets = data.getIntExtra(addIntoList.EXTRA_SETS, 1);
            minwt = data.getIntExtra(addIntoList.EXTRA_MINWT, 1);
            maxwt = data.getIntExtra(addIntoList.EXTRA_MAXWT, 1);

            recyclerView.setVisibility(View.VISIBLE);
            relativeLayout.setVisibility(View.GONE);
            adapter.setListData(viewModel.addData(name,sets,minwt,maxwt));
            recyclerView.setAdapter(adapter);

        }else if(requestCode==EDIT_REQ_CODE && resultCode==RESULT_OK){

            id =  data.getLongExtra(addIntoList.EXTRA_ID,1);
            name  = data.getStringExtra(addIntoList.EXTRA_NAME);
            sets = data.getIntExtra(addIntoList.EXTRA_SETS,1);
            minwt = data.getIntExtra(addIntoList.EXTRA_MINWT,1);
            maxwt = data.getIntExtra(addIntoList.EXTRA_MAXWT,1);
            Log.d("ON Receiving: ",String.valueOf(id));
            recyclerView.setVisibility(View.VISIBLE);
            relativeLayout.setVisibility(View.GONE);
            adapter.setListData(viewModel.updateData(id,name,sets,minwt,maxwt));
            recyclerView.setAdapter(adapter);
        }

    }

    private  boolean isDbPresent(String table_name){
        SQLiteDatabase testDb=null;
        String table_path = "data/user/0/com.example.saikumar.myapplication/databases/"+table_name;
        boolean checkFlag=true;
        try{
            testDb  = SQLiteDatabase.openDatabase(table_path,null,SQLiteDatabase.OPEN_READWRITE);
        }catch(SQLiteException e){
            viewModel = new exerciseViewModel(getApplication(),table_name);
            adapter.setListData(viewModel.loadData());
            recyclerView.setAdapter(adapter);
            recyclerView.setVisibility(View.GONE);
            relativeLayout.setVisibility(View.VISIBLE);
        }
        if(testDb!=null)
            testDb.close();
        return true;
    }


}
