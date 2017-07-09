package com.example.bublly.bemedisure;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class LogIN extends AppCompatActivity {

    New_Registration new_registration = new New_Registration(this);

    private static EditText get_email;
    private static EditText get_password;
    public LinearLayout linearLayout;
    public TextView registrtion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        linearLayout = (LinearLayout)findViewById(R.id.Linear_Layout);
        linearLayout.setAlpha((float) 0.8);

        registrtion = (TextView)findViewById(R.id.textView16);
        get_email = (EditText)findViewById(R.id.email);
        get_password = (EditText)findViewById(R.id.editText2);
    }

    public void Sign_In(View V)
    {
        String email = get_email.getText().toString();
        String password = get_password.getText().toString();

        if (email.length() != 0 && password.length() != 0) {
            String pass_word = new_registration.verifyInformation(email);

            if (pass_word.equals(password)) {
                Intent intent1 = new Intent(LogIN.this , Medical_Info.class);
                Toast.makeText(LogIN.this, "LogIn Successful !!!", Toast.LENGTH_SHORT).show();
                startActivity(intent1);
                get_email.setText(null);
                get_password.setText(null);
            } else {
                Toast.makeText(LogIN.this, "Invalid Username or Password !!!", Toast.LENGTH_LONG).show();
                get_email.setText(null);
                get_password.setText(null);
            }
        } else {
            Toast.makeText(LogIN.this, "Fields can't be empty !!!", Toast.LENGTH_LONG).show();

        }
    }

    public void onRegistrationClicked(View v)
    {
        Intent intent = new Intent(LogIN.this,Registration.class);
        startActivity(intent);
    }

}
