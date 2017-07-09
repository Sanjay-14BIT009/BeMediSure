package com.example.bublly.bemedisure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class Doctor_Search extends AppCompatActivity {

    private static ListView mainListView;
    private ArrayAdapter<String> listAdapter ;

    String[] planets = new String[] { "Audiologist", "Allergist" , "Cardiologist", "Dentist",
            "Dermatologist", "Gynecologist" , "Microbiologist", "Orthopedic Surgeon" , "Physician" , "Pediatrician" , "Psychiatrist"};

        @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_doctor__search);
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
                            Intent new_Activity = new Intent(Doctor_Search.this, Audiologist.class);
                            startActivity(new_Activity);
                            break;
                        case 1:
                            Intent newActivity1 = new Intent(Doctor_Search.this, Allergist.class);
                            startActivity(newActivity1);
                            break;
                        case 2:
                            Intent newActivity2 = new Intent(Doctor_Search.this, Cardiologist.class);
                            startActivity(newActivity2);
                            break;
                        case 3:
                            Intent newActivity3 = new Intent(Doctor_Search.this, Dentist.class);
                            startActivity(newActivity3);
                            break;
                        case 4:
                            Intent newActivity4 = new Intent(Doctor_Search.this, Dermatolosist.class);
                            startActivity(newActivity4);
                            break;
                        case 5:
                            Intent newActivity5 = new Intent(Doctor_Search.this, Microbiologist.class);
                            startActivity(newActivity5);
                            break;
                        case 6:
                            Intent newActivity6 = new Intent(Doctor_Search.this, Gynecologist.class);
                            startActivity(newActivity6);
                            break;
                        case 7:
                            Intent newActivity7 = new Intent(Doctor_Search.this, Orthopedic_Surgeon.class);
                            startActivity(newActivity7);
                            break;
                        case 8:
                            Intent newActivity8 = new Intent(Doctor_Search.this, Physician.class);
                            startActivity(newActivity8);
                            break;
                        case 9:
                            Intent newActivity9 = new Intent(Doctor_Search.this, Pediatrician.class);
                            startActivity(newActivity9);
                            break;
                        case 10:
                            Intent newActivity10 = new Intent(Doctor_Search.this, Psychiatrist.class);
                            startActivity(newActivity10);
                            break;
                    }
                }

                @SuppressWarnings("unused")
                public void onClick(View v) {

                }

            });
    }

    /*@Override
    protected void onListItemClick(ListView l, View v, int position, long id)
    {
        // TODO Auto-generated method stub
        super.onListItemClick(l, v, position, id);

        if (position == 0) {
            Intent intent = new Intent(this, QuizActivity.class);
            startActivity(intent);
        }
        else if (position == 1) {
            Intent intent = new Intent(this, SignUp.class);
            startActivity(intent);
        }
        else if (position == 2) {
            Intent intent = new Intent(this, FriendList.class);
            startActivity(intent);
        }
    }*/


}
