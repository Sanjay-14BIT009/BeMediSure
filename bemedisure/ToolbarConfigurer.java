package com.example.bublly.bemedisure;

import android.app.Activity;
import android.support.v4.app.NavUtils;
import android.view.View;
import android.support.v7.widget.Toolbar;

/**
 * Created by BUBLLY on 18-08-2016.
 */
public class ToolbarConfigurer implements View.OnClickListener {
    private Activity activity;

    public ToolbarConfigurer(Activity activity, Toolbar toolbar, boolean displayHomeAsUpEnabled) {
        toolbar.setTitle((this.activity = activity).getTitle());
        if (!displayHomeAsUpEnabled) return;
        toolbar.setNavigationOnClickListener(this);
    }

    public ToolbarConfigurer(Deaseses_Search activity, android.support.v7.widget.Toolbar viewById, boolean displayHomeAsUpEnabled) {

    }

    @Override
    public void onClick(View v) {
        NavUtils.navigateUpFromSameTask(activity);
    }
}
