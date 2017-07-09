package com.example.bublly.bemedisure;

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

public class Gynecologist extends AppCompatActivity {

    private static ListView mainListView;
    private ArrayAdapter<String> listAdapter ;

    String[] planets = new String[] { "Doctor 1" , "Doctor 2" , "Doctor 3" , "Doctor 4" , "Doctor 5" , "Doctor 6" , "Doctor 7" , "Doctor 8" , "Doctor 9" , "Doctor 10"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gynecologist);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mainListView = (ListView) findViewById(R.id.mainListView);

        // Create and populate a List of planet names

        ArrayList<String> planetList = new ArrayList<String>();
        planetList.addAll(Arrays.asList(planets));

        // Create ArrayAdapter using the planet list.
        listAdapter = new ArrayAdapter<String>(this, R.layout.list_view, planetList);

        mainListView.setAdapter(listAdapter);

        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /*switch (position) {
                    case 0:
                        Intent newActivity = new Intent(Doctor_Search.this, Notifications.class);
                        startActivity(newActivity);
                        break;
                    case 1:
                        Intent newActivity1 = new Intent(Doctor_Search.this, School.class);
                        startActivity(newActivity1);
                        break;
                    case 2:
                        Intent newActivity2 = new Intent(Doctor_Search.this, Whats_hot.class);
                        startActivity(newActivity2);
                        break;
                    case 3:
                        Intent newActivity3 = new Intent(Doctor_Search.this, Tellafriend.class);
                        startActivity(newActivity3);
                        break;
                    case 4:
                        Intent newActivity4 = new Intent(Doctor_Search.this, Hitusup.class);
                        startActivity(newActivity4);
                        break;
                    case 5:
                        Intent newActivity5 = new Intent(Doctor_Search.this, Settings.class);
                        startActivity(newActivity5);
                        break;
                    case 6:
                        Intent newActivity6 = new Intent(Doctor_Search.this, AboutHelp.class);
                        startActivity(newActivity6);
                        break;
                }*/
            }

            @SuppressWarnings("unused")
            public void onClick(View v) {

            }

        });
    }

}
