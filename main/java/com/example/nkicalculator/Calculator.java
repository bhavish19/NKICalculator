package com.example.nkicalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class Calculator extends AppCompatActivity {
    static int nki;
    static String D;
    static int b, l, d, g, s, F, E, T;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Button calculate = (Button) findViewById(R.id.calculate);
        final EditText date = (EditText) findViewById(R.id.date);
        final EditText breakfast = (EditText) findViewById(R.id.breakfast);
        final EditText lunch = (EditText) findViewById(R.id.lunch);
        final EditText dinner = (EditText) findViewById(R.id.dinner);
        final EditText gym = (EditText) findViewById(R.id.gym);
        final EditText sport = (EditText) findViewById(R.id.sport);
        final TextView foodtot = (TextView) findViewById(R.id.totfood);
        final TextView exercisetot = (TextView) findViewById(R.id.totexercise);
        final TextView total = (TextView) findViewById(R.id.total);


        final View.OnClickListener x = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (breakfast.getText().toString().equals(""))
                    breakfast.setText("0");
                if (lunch.getText().toString().equals(""))
                    lunch.setText("0");
                if (dinner.getText().toString().equals(""))
                    dinner.setText("0");
                if (gym.getText().toString().equals(""))
                    gym.setText("0");
                if (sport.getText().toString().equals(""))
                    sport.setText("0");

                int num1 = Integer.parseInt(breakfast.getText().toString()) + Integer.parseInt(lunch.getText().toString()) + Integer.parseInt(dinner.getText().toString());
                int num2 = Integer.parseInt(gym.getText().toString()) + Integer.parseInt(sport.getText().toString());

                int tot = num1 - num2;
                nki = tot;
                foodtot.setText("Food: \t" + String.valueOf(num1));
                exercisetot.setText("Exercise: \t" + String.valueOf(num2));
                total.setText("Total: \t\t" + String.valueOf(tot));
            }
        };
        calculate.setOnClickListener(x);

        FloatingActionButton fab = findViewById(R.id.confirm);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //calculate.setOnClickListener(x);
                if (breakfast.getText().toString().equals(""))
                    breakfast.setText("0");
                if (lunch.getText().toString().equals(""))
                    lunch.setText("0");
                if (dinner.getText().toString().equals(""))
                    dinner.setText("0");
                if (gym.getText().toString().equals(""))
                    gym.setText("0");
                if (sport.getText().toString().equals(""))
                    sport.setText("0");

                D = date.getText().toString();
                b = Integer.parseInt(breakfast.getText().toString());
                l = Integer.parseInt(lunch.getText().toString());
                d = Integer.parseInt(dinner.getText().toString());
                g = Integer.parseInt(gym.getText().toString());
                s = Integer.parseInt(sport.getText().toString());
                F = b+l+d;
                E = g+s;
                T = F-E;

                Intent dia = new Intent(getApplicationContext(), Diary.class);
                //dia.putExtra("nki", nki);
                //dia.putExtra("date", Integer.parseInt(date.getText().toString()));
                String in = D + "\t\t NKI: " + T;
                MainActivity.notes.add(in);
                MainActivity.br.add(b);
                MainActivity.lu.add(l);
                MainActivity.di.add(d);
                MainActivity.gy.add(g);
                MainActivity.sp.add(s);
                MainActivity.foodtot.add(F);
                MainActivity.exetot.add(E);
                MainActivity.tot.add(T);
                finish();
                startActivity(dia);
            }
        });

        FloatingActionButton can = findViewById(R.id.cancel);
        can.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(back);
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
