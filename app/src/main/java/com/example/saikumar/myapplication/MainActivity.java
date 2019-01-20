package com.example.saikumar.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView Mon =(TextView) findViewById(R.id.Day1);
        Mon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,exerciseList.class);
                intent.putExtra(Intent.EXTRA_TEXT,"1");
                startActivity(intent);

            }
        });
        TextView Tues =(TextView) findViewById(R.id.Day2);
        Tues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,exerciseList.class);
                intent.putExtra(Intent.EXTRA_TEXT,"2");
                startActivity(intent);

            }
        });
        TextView Wed =(TextView) findViewById(R.id.Day3);
        Wed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,exerciseList.class);
                intent.putExtra(Intent.EXTRA_TEXT,"3");
                startActivity(intent);

            }
        });
        TextView Thurs =(TextView) findViewById(R.id.Day4);
        Thurs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,exerciseList.class);
                intent.putExtra(Intent.EXTRA_TEXT,"4");
                startActivity(intent);

            }
        });
        TextView Fri =(TextView) findViewById(R.id.Day5);
        Fri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,exerciseList.class);
                intent.putExtra(Intent.EXTRA_TEXT,"5");
                startActivity(intent);

            }
        });
        TextView Sat =(TextView) findViewById(R.id.Day6);
        Sat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,exerciseList.class);
                intent.putExtra(Intent.EXTRA_TEXT,"6");
                startActivity(intent);

            }
        });
        TextView Sun =(TextView) findViewById(R.id.Day7);
        Sun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,exerciseList.class);
                intent.putExtra(Intent.EXTRA_TEXT,"7");
                startActivity(intent);

            }
        });


    }
}

