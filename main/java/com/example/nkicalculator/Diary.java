package com.example.nkicalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Diary extends AppCompatActivity {
    int noteId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //final EditText date = (EditText) findViewById(R.id.date);
        final TextView breakfast = (TextView) findViewById(R.id.breakfast);
        final TextView lunch = (TextView) findViewById(R.id.lunch);
        final TextView dinner = (TextView) findViewById(R.id.dinner);
        final TextView gym = (TextView) findViewById(R.id.gym);
        final TextView sport = (TextView) findViewById(R.id.sport);
        final TextView food = (TextView) findViewById(R.id.food);
        final TextView exercise = (TextView) findViewById(R.id.exercise);
        final TextView total = (TextView) findViewById(R.id.avgnki);

        Intent a = getIntent();
        noteId = a.getIntExtra("noteId",-1);
        if (noteId!=-1){
            breakfast.setText("Breakfast: \t" + MainActivity.br.get(noteId));
            lunch.setText("Lunch: \t" + MainActivity.lu.get(noteId));
            dinner.setText("Dinner: \t" + MainActivity.di.get(noteId));
            gym.setText("Gym: \t" + MainActivity.gy.get(noteId));
            sport.setText("Sport: \t" + MainActivity.sp.get(noteId));
            food.setText("Food: \t" + MainActivity.foodtot.get(noteId));
            exercise.setText("Exercise: \t" + MainActivity.exetot.get(noteId));
            total.setText("NKI: \t" + MainActivity.tot.get(noteId));
        }
        else{
            breakfast.setText("Breakfast: \t" + Calculator.b);
            lunch.setText("Lunch: \t" + Calculator.l);
            dinner.setText("Dinner: \t" + Calculator.d);
            gym.setText("Gym: \t" + Calculator.g);
            sport.setText("Sport: \t" + Calculator.s);
            food.setText("Food: \t" + Calculator.F);
            exercise.setText("Exercise: " + Calculator.E);
            total.setText("NKI: \t" + Calculator.T);
        }



        FloatingActionButton fab = findViewById(R.id.next);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (noteId+1<MainActivity.notes.size()) {
                    noteId++;
                    breakfast.setText("Breakfast: \t" + MainActivity.br.get(noteId));
                    lunch.setText("Lunch: \t" + MainActivity.lu.get(noteId));
                    dinner.setText("Dinner: \t" + MainActivity.di.get(noteId));
                    gym.setText("Gym: \t" + MainActivity.gy.get(noteId));
                    sport.setText("Sport: \t" + MainActivity.sp.get(noteId));
                    food.setText("Food: \t" + MainActivity.foodtot.get(noteId));
                    exercise.setText("Exercise: \t" + MainActivity.exetot.get(noteId));
                    total.setText("NKI: \t" + MainActivity.tot.get(noteId));
                }
                else{
                    Toast.makeText(getApplicationContext(), "No next item found!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab1 =findViewById(R.id.previous);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (noteId>0) {
                    noteId--;
                    breakfast.setText("Breakfast: \t" + MainActivity.br.get(noteId));
                    lunch.setText("Lunch: \t" + MainActivity.lu.get(noteId));
                    dinner.setText("Dinner: \t" + MainActivity.di.get(noteId));
                    gym.setText("Gym: \t" + MainActivity.gy.get(noteId));
                    sport.setText("Sport: \t" + MainActivity.sp.get(noteId));
                    food.setText("Food: \t" + MainActivity.foodtot.get(noteId));
                    exercise.setText("Exercise: \t" + MainActivity.exetot.get(noteId));
                    total.setText("NKI: \t" + MainActivity.tot.get(noteId));
                }
                else{
                    Toast.makeText(getApplicationContext(), "No previous item found!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button calc = findViewById(R.id.calculator);
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent calc = new Intent(getApplicationContext(), Calculator.class);
                finish();
                startActivity(calc);
            }
        });

        Button overview = findViewById(R.id.overview);
        overview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ov = new Intent(getApplicationContext(), MainActivity.class);
                finish();
                startActivity(ov);
            }
        });
    }

}
