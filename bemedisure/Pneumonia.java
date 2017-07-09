package com.example.bublly.bemedisure;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Pneumonia extends AppCompatActivity {

    public Button medicine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pneumonia);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        medicine = (Button) findViewById(R.id.button5);

    }

    public void Medicine(View V)
    {
        Intent intent = new Intent(Pneumonia.this , Acetaminophen.class);
        startActivity(intent);
    }

}
