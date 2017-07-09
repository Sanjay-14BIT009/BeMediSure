package com.example.bublly.bemedisure;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

public class Allergist extends AppCompatActivity {

    private static ListView mainListView;
    private static TextView textView;
    private ArrayAdapter<String> listAdapter ;

    String[] planets = new String[] { "Dr Raj Bhagat" , "Dr Rajesh Shah" , "Doctor 3" , "Doctor 4" , "Doctor 5" , "Doctor 6" , "Doctor 7" , "Doctor 8" , "Doctor 9" , "Doctor 10"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audiologist);
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
                switch (position) {
                    case 0:
                        Intent newActivity = new Intent(Allergist.this, alle0001.class);
                        startActivity(newActivity);
                        break;
                    case 1:
                        Intent newActivity1 = new Intent(Allergist.this, alle0002.class);
                        startActivity(newActivity1);
                        break;
                }
            }

            @SuppressWarnings("unused")
            public void onClick(View v) {

            }

        });
    }

    /*public void settex(JSONArray jsonArray)
    {
        String S = "";

        for(int i = 0 ; i <jsonArray.length() ; i++)
        {
            JSONObject jsonObject = null;

            try
            {
                jsonObject = jsonArray.getJSONObject(i);

                S = S + "ID : "+jsonObject.getString("doctor_ID")+"vi"+
                        "Name : "+jsonObject.getString("name")+"vi+" +
                        "Speciality : "+jsonObject.getString("speciality")+"vi\n";
            }
            catch (JSONException e)
            {
                e.printStackTrace();
            }
        }
    }

    public class getDoctorsList extends AsyncTask<API_Connector , Long , JSONArray>
    {
        @Override
        protected JSONArray doInBackground(API_Connector... params) {
            return params[0].getDoctorList();
        }

        @Override
        protected void onPostExecute(JSONArray jsonArray) {
            settex(jsonArray);
        }
    }*/
}
