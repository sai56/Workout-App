package com.example.saikumar.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class exerciseAdapter extends RecyclerView.Adapter<exerciseAdapter.ExerciseViewHolder> {

    private List<exercise> listData = new ArrayList<>();
    public onItemClickListener listener;

    @NonNull
    @Override
    public ExerciseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.exercise_view,viewGroup,false);
        return new ExerciseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseViewHolder exerciseViewHolder, int i) {
        exercise newView = listData.get(i);
        exerciseViewHolder.id = newView.id;
        exerciseViewHolder.mName.setText(newView.excerciseName);
        exerciseViewHolder.mSets.setText(String .valueOf(newView.sets));
        exerciseViewHolder.mMinWt.setText(String.valueOf(newView.minWeight));
        exerciseViewHolder.mMaxWt.setText(String.valueOf(newView.maxWeight));
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public void setListData(List<exercise> list){
        listData = list;
        notifyDataSetChanged();
    }

    public long getID(int position){
        return listData.get(position).id;
    }

    public interface onItemClickListener{
        public void onItemClick(exercise Exercise);
    }

    public void setOnItemClickListener(onItemClickListener listener){
        this.listener = listener;
    }

    public class ExerciseViewHolder extends RecyclerView.ViewHolder{

        TextView mName;
        TextView mSets;
        TextView mMinWt;
        TextView mMaxWt;
        public long id;

        public ExerciseViewHolder(@NonNull View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.exercise);
            mSets = itemView.findViewById(R.id.reps_number);
            mMinWt = itemView.findViewById(R.id.minwt_val);
            mMaxWt = itemView.findViewById(R.id.maxwt_val);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    Log.d("POSITION: ",String.valueOf(pos));
                    if(listener!=null && pos!=RecyclerView.NO_POSITION)
                        listener.onItemClick(listData.get(pos));
                        Log.d("CLICKED: ",String.valueOf(listData.get(pos).id));

                }
            });
        }

    }
}
