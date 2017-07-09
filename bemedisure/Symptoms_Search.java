package com.example.bublly.bemedisure;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class Symptoms_Search extends AppCompatActivity {

    private static ListView mainListView;
    private ArrayAdapter<String> listAdapter ;

    String[] planets = new String[] { "High Fever" , "Head-ache" , "Pain Behind The Eyes" , "Muscle Pain" , "Fatigue" , "Vomiting" , "Skin Rash" , "Mild Bleeding" ,"Cough" , "Shortness of Breath" , "Excessive Sweating"
 };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptoms__search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mainListView = (ListView) findViewById(R.id.mainListView);

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
                    /*case 0:
                        Intent new_Activity = new Intent(Symptoms_Search.this, Symptoms1.class);
                        startActivity(new_Activity);
                        break;
                    case 1:
                        Intent newActivity1 = new Intent(Symptoms_Search.this, Symptoms2.class);
                        startActivity(newActivity1);
                        break;
                    case 2:
                        Intent newActivity2 = new Intent(Symptoms_Search.this, Symptoms3.class);
                        startActivity(newActivity2);
                        break;
                    case 3:
                        Intent newActivity3 = new Intent(Symptoms_Search.this, Symptoms4.class);
                        startActivity(newActivity3);
                        break;
                    case 4:
                        Intent newActivity4 = new Intent(Symptoms_Search.this, Symptoms5.class);
                        startActivity(newActivity4);
                        break;
                    case 5:
                        Intent newActivity5 = new Intent(Symptoms_Search.this, Symptoms6.class);
                        startActivity(newActivity5);
                        break;
                    case 6:
                        Intent newActivity6 = new Intent(Symptoms_Search.this,Symptoms7.class);
                        startActivity(newActivity6);
                        break;
                    case 7:
                        Intent newActivity7 = new Intent(Symptoms_Search.this, Symptoms8.class);
                        startActivity(newActivity7);
                        break;
                    case 8:
                        Intent newActivity8 = new Intent(Symptoms_Search.this, Symptoms9.class);
                        startActivity(newActivity8);
                        break;
                    case 9:
                        Intent newActivity9 = new Intent(Symptoms_Search.this, Symptoms10.class);
                        startActivity(newActivity9);
                        break;
                    case 10:
                        Intent newActivity10 = new Intent(Symptoms_Search.this, Symptoms11.class);
                        startActivity(newActivity10);
                        break;*/
                }
            }

            @SuppressWarnings("unused")
            public void onClick(View v) {

            }

        });
    }

}
