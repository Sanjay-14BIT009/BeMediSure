package com.example.bublly.bemedisure;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class Deaseses_Search extends AppCompatActivity {

    private static ListView mainListView;
    private ArrayAdapter<String> listAdapter ;
    private Button Symptom_search;

    String[] planets = new String[] { "Dengue", "Pneumonia" , "Disease1", "Disease2",
            "Disease3", "Disease4" , "Disease5", "Disease6" , "Disease7" , "Disease8" , "Disease9"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deaseses__search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mainListView = (ListView) findViewById(R.id.mainListView);
        Symptom_search = (Button) findViewById(R.id.button4);

        // Create and populate a List of planet names

        ArrayList<String> planetList = new ArrayList<String>();
        planetList.addAll(Arrays.asList(planets));

        // Create ArrayAdapter using the planet list.
        listAdapter = new ArrayAdapter<String>(this, R.layout.list_view, planetList);

        // Add more planets. If you passed a String[] instead of a List<String>
        // into the ArrayAdapter constructor, you must not add more items.
        // Otherwise an exception will occur.

        // Set the ArrayAdapter as the ListView's adapter.
        mainListView.setAdapter(listAdapter);

        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent new_Activity = new Intent(Deaseses_Search.this, Dengue.class);
                        startActivity(new_Activity);
                        break;
                    case 1:
                        Intent newActivity1 = new Intent(Deaseses_Search.this, Pneumonia.class);
                        startActivity(newActivity1);
                        break;
                    /*case 2:
                        Intent newActivity2 = new Intent(Deaseses_Search.this, Disease1.class);
                        startActivity(newActivity2);
                        break;
                    case 3:
                        Intent newActivity3 = new Intent(Deaseses_Search.this, Disease1.class);
                        startActivity(newActivity3);
                        break;
                    case 4:
                        Intent newActivity4 = new Intent(Deaseses_Search.this, Disease1.class);
                        startActivity(newActivity4);
                        break;
                    case 5:
                        Intent newActivity5 = new Intent(Deaseses_Search.this, Disease1.class);
                        startActivity(newActivity5);
                        break;
                    case 6:
                        Intent newActivity6 = new Intent(Deaseses_Search.this, Disease1.class);
                        startActivity(newActivity6);
                        break;
                    case 7:
                        Intent newActivity7 = new Intent(Deaseses_Search.this, Disease1.class);
                        startActivity(newActivity7);
                        break;
                    case 8:
                        Intent newActivity8 = new Intent(Deaseses_Search.this, Disease1.class);
                        startActivity(newActivity8);
                        break;
                    case 9:
                        Intent newActivity9 = new Intent(Deaseses_Search.this, Disease1.class);
                        startActivity(newActivity9);
                        break;
                    case 10:
                        Intent newActivity10 = new Intent(Deaseses_Search.this, Disease1t.class);
                        startActivity(newActivity10);
                        break;*/
                }
            }

            @SuppressWarnings("unused")
            public void onClick(View v) {

            }

        });
    }

    public void onSymptomsClicked(View V)
    {
        Intent intent = new Intent(Deaseses_Search.this , Symptoms_Search.class);
        startActivity(intent);
    }
}
