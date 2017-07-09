package com.example.bublly.bemedisure;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Home_Page extends AppCompatActivity {

    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    private static Button deaseses;
    private static Button medicines;
    private static Button doctors;
    private Button Symptom_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__page);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mNavigationView = (NavigationView) findViewById(R.id.shitstuff);
        Symptom_search = (Button) findViewById(R.id.button4);

        /**
         * Lets inflate the very first fragment
         * Here , we are inflating the TabFragment as the first Fragment
         */

        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.containerView,new com.example.bublly.bemedisure.Home()).commit();
        /**
         * Setup click events on the Navigation View Items.
         */

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                mDrawerLayout.closeDrawers();

                if (menuItem.getItemId() == R.id.nav_item_home) {
                    FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                    xfragmentTransaction.replace(R.id.containerView,new com.example.bublly.bemedisure.Home()).commit();
                 }

                if (menuItem.getItemId() == R.id.nav_item_reminder) {
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new com.example.bublly.bemedisure.Reminder()).commit();
                }

                if (menuItem.getItemId() == R.id.nav_item_history) {
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView,new com.example.bublly.bemedisure.Search_History()).commit();
                }

                if (menuItem.getItemId() == R.id.nav_item_help) {
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView,new com.example.bublly.bemedisure.Help()).commit();
                }

                if (menuItem.getItemId() == R.id.nav_item_settings) {
                    FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                    xfragmentTransaction.replace(R.id.containerView,new com.example.bublly.bemedisure.Settings()).commit();
                }

                if (menuItem.getItemId() == R.id.nav_item_about) {
                    FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                    xfragmentTransaction.replace(R.id.containerView,new com.example.bublly.bemedisure.About()).commit();
                }

                return false;
            }

        });

        /**
         * Setup Drawer Toggle of the Toolbar
         */

        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(Home_Page.this,mDrawerLayout, toolbar,R.string.app_name,
                R.string.app_name);

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        mDrawerToggle.syncState();
    }

    public void onDeasesesButtonClicked(View v)
    {
        Intent intent = new Intent(Home_Page.this, Deaseses_Search.class);
        startActivity(intent);
    }

    public void onMedicinesButtonClicked(View v)
    {
        Intent intent = new Intent(Home_Page.this, Medicine_Search.class);
        startActivity(intent);
    }

    public void onDoctorsButtonClicked(View v)
    {
        Intent intent = new Intent(Home_Page.this, Doctor_Search.class);
        startActivity(intent);
    }

    public void onHeaderClicked(View v)
    {
        Intent intent = new Intent(Home_Page.this , LogIN.class);
        startActivity(intent);
    }

    public void onSymptomsClicked(View V)
    {
        Intent intent = new Intent(Home_Page.this , Symptoms_Search.class);
        startActivity(intent);
    }
}
