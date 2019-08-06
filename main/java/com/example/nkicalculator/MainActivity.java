package com.example.nkicalculator;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.JsonReader;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    static ArrayList<String> notes = new ArrayList<>();
    static ArrayList<Integer> br = new ArrayList<>();
    static ArrayList<Integer> lu = new ArrayList<>();
    static ArrayList<Integer> di = new ArrayList<>();
    static ArrayList<Integer> gy = new ArrayList<>();
    static ArrayList<Integer> sp = new ArrayList<>();
    static ArrayList<Integer> foodtot = new ArrayList<>();
    static ArrayList<Integer> exetot = new ArrayList<>();
    static ArrayList<Integer> tot = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //load(getApplicationContext());
        ListView lv = (ListView) findViewById(R.id.nkilist);
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_list_item_1, notes);
        lv.setAdapter(aa);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent detail = new Intent(getApplicationContext(), Diary.class);
                detail.putExtra("noteId", position);
                startActivity(detail);
            }
        });

        //save();
        //load(getApplicationContext());
        UpdateAvgDailyNKI();

        FloatingActionButton fab = findViewById(R.id.calculator);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cal = new Intent(getApplicationContext(), Calculator.class);
                finish();
                startActivity(cal);
                //finish();
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void UpdateAvgDailyNKI(){
        final TextView avgDailyNKI = findViewById(R.id.avgnki);
        int sum=0;
        double avg;
        for (int i = 0; i<tot.size();i++)
            sum+=tot.get(i);
        int nki = notes.size();
        if (nki==0)
                avg=0;
        else
            avg = (double)sum/nki;
        String Text = (String)  getText(R.string.nki);
        String NKIText = Text + " " + String.format("%.2f",avg);
        avgDailyNKI.setText(NKIText);
    }

    /*public boolean save(){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor edit = sp.edit();
        edit.putInt("size",notes.size());

        for (int i=0;i<notes.size();i++){
            edit.remove("Status"+i);
            edit.putString("Status"+i,notes.get(i));
        }
        return edit.commit();
    }

    public static void load (Context context){
        SharedPreferences spp = PreferenceManager.getDefaultSharedPreferences(context);
        notes.clear();
        int size = spp.getInt("size",0);

        for ( int i=0;i<size;i++){
            notes.add(spp.getString("Status"+i,"sndec"));
        }
    }*/
}
