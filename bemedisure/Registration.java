package com.example.bublly.bemedisure;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registration extends AppCompatActivity {

    public LinearLayout linearLayout;
    private static Button sign_up;
    private static EditText get_email;
    private static EditText get_password;
    public TextView logIn;
    Context context = this;
    New_Registration new_registration;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        logIn = (TextView)findViewById(R.id.textView16);
        sign_up = (Button)findViewById(R.id.button5);
        get_email = (EditText)findViewById(R.id.email);
        get_password = (EditText)findViewById(R.id.editText2);
        linearLayout = (LinearLayout)findViewById(R.id.Linear_Layout);
        linearLayout.setAlpha((float) 0.8);
    }

    public void addInfo(View V) {

        String email = get_email.getText().toString();
        String password = get_password.getText().toString();

        if(email.length() == 0) {
            get_email.requestFocus();
            get_email.setError("FIELD CANNOT BE EMPTY");
        }  else if (!pwdValid(password)) {
            get_password.requestFocus();
            get_password.setError("Invalid Password !!!");
            Toast.makeText(getBaseContext(), "Password Must be Min. 6 And Max. 16 Letter Long !!!\n" +
                    "Password Must be Consist Of Min. 1 Upper-Case and Min. 1 Lower-Case Letter With Min. 1 Digit And Min. 1 Special Character !!!", Toast.LENGTH_LONG).show();
            get_password.setText(null);
        } else {
            new_registration = new New_Registration(context);
            sqLiteDatabase = new_registration.getWritableDatabase();
            new_registration.addInformation(email , password, sqLiteDatabase);
            Toast.makeText(getBaseContext(), "Registration Successfully Done !!!", Toast.LENGTH_LONG).show();
            new_registration.close();
        }
    }

    private boolean pwdValid(String password){

        String PWD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,16})";
        Pattern pattern = Pattern.compile(PWD_PATTERN);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public void onLoginClicked(View v)
    {
        Intent intent = new Intent(Registration.this ,LogIN.class);
        startActivity(intent);
    }

}
