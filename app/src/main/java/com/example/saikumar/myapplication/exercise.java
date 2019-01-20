package com.example.saikumar.myapplication;

public class exercise {

    public long id;
    public String excerciseName;
    public int sets;
    public int minWeight;
    public int maxWeight;

    exercise(long id, String excerciseName, int sets, int minWeight, int maxWeight){
        this.id=id;
        this.excerciseName = excerciseName;
        this.sets = sets;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
    }

}
