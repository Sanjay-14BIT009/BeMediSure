package com.example.bublly.bemedisure;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class alle0002 extends AppCompatActivity {

    TextView al2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alle0002);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        al2 = (TextView)findViewById(R.id.textView19);

        al2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MapsActivity.class);
                String s1 = "23.017431";
                String s2 = "72.566824";
                i.putExtra("name1", s1);
                i.putExtra("name2", s2);
                startActivity(i);
            }
        });
    }

}
