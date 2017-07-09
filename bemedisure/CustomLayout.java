package com.example.bublly.bemedisure;

/**
 * Created by BUBLLY on 28-08-2016.
 */
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomLayout extends ArrayAdapter<String>{

    private final Activity context;
    private final String[] planets;
    private final Integer[] imageId;
    public CustomLayout(Activity context, String[] planets, Integer[] imageId)
    {
        super(context, R.layout.list_view , R.id.rowTextView, planets);
        this.context = context;
        this.planets = planets;
        this.imageId = imageId;
    }
    /*@Override
    public View getView(int position, View view, ViewGroup parent)
    {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_view, null, true);
        TextView txtTitle = (TextView) listViewItem.findViewById(R.id.rowTextView);
        ImageView imageView = (ImageView) listViewItem.findViewById(R.id.imageView);
        txtTitle.setText(planets[position]);

        txtTitle.setText(planets[position]);
        imageView.setImageResource(imageId[position]);
        return listViewItem;
    }*/
}
