package com.example.bublly.bemedisure;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class card0001 extends AppCompatActivity {

    TextView ca1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card0001);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ca1 = (TextView)findViewById(R.id.textView19);

        ca1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MapsActivity.class);
                String s1 = "23.045754";
                String s2 = "72.514582";
                i.putExtra("name1", s1);
                i.putExtra("name2", s2);
                startActivity(i);
            }
        });
    }

}
