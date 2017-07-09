package com.example.bublly.bemedisure;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.google.android.gms.common.api.GoogleApiClient;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by BUBLLY on 04-10-2016.
 */
public class AllDoctorActivity extends ListActivity {
    // Progress Dialog
    private ProgressDialog pDialog;
    // Creating JSON Parser object
    JSONParser jParser = new JSONParser();

    ArrayList<HashMap<String, String>> doctorsList;

    // url to get all doctors list
    private static String url_all_doctors = "http://sanjay.com/Android_Connect/get_doctors_details.php";

    // JSON Node names
    private static final String TAG_SUCCESS = "success";

    private static final String TAG_doctors = "doctors";
    private static final String TAG_doctor_ID = "doctor_ID";
    private static final String TAG_NAME = "doctor_name";

    // doctors JSONArray
    JSONArray doctors = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alldoctor);

        // Hashmap for ListView
        doctorsList = new ArrayList<HashMap<String, String>>();

        // Loading doctors in Background Thread
        new LoadAlldoctors().execute();

        // Get listview
        ListView lv = getListView();

        // on seleting single product
        // launching Edit Product Screen
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // getting values from selected ListItem
                String doctor_ID = ((TextView) view.findViewById(R.id.doctor_ID)).getText().toString();

                // Starting new intent
                Intent in = new Intent(AllDoctorActivity.this, Doctor_Activity.class);

                // sending doctor_ID to next activity
                in.putExtra(TAG_doctor_ID, doctor_ID);

                // starting new activity and expecting some response back
                startActivityForResult(in, 100);
            }
        });
    }

    // Response from Edit Product Activity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // if result code 100
        if (resultCode == 100) {
            // if result code 100 is received
            // means user edited/deleted product
            // reload this screen again
            Intent intent = getIntent();
            finish();
            startActivity(intent);
        }
    }

    /**
     * Background Async Task to Load all product by making HTTP Request
     */
    class LoadAlldoctors extends AsyncTask<String, String, String> {
        /**
         * Before starting background thread Show Progress Dialog
         */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(AllDoctorActivity.this);
            pDialog.setMessage("Loading doctors. Please wait...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        /**
         * getting All doctors from url
         */

        protected String doInBackground(String... args) {
            // Building Parameters

            List<NameValuePair> params = new ArrayList<NameValuePair>();

            // getting JSON string from URL

            JSONObject json = null;
            try {
                json = jParser.makeHttpRequest(url_all_doctors, "GET", params);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Check your log cat for JSON reponse
            Log.d("All doctors: ", json.toString());

            try {
                // Checking for SUCCESS TAG
                int success = json.getInt(TAG_SUCCESS);

                if (success == 1) {
                    // doctors found
                    // Getting Array of doctors
                    doctors = json.getJSONArray(TAG_doctors);
                    // looping through All doctors

                    for (int i = 0; i < doctors.length(); i++) {
                        JSONObject c = doctors.getJSONObject(i);

                        // Storing each json item in variable
                        String id = c.getString(TAG_doctor_ID);
                        String name = c.getString(TAG_NAME);

                        // creating new HashMap
                        HashMap<String, String> map = new HashMap<String, String>();

                        // adding each child node to HashMap key => value
                        map.put(TAG_doctor_ID, id);
                        map.put(TAG_NAME, name);

                        // adding HashList to ArrayList
                        doctorsList.add(map);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        /**
         * After completing background task Dismiss the progress dialog
         **/
        protected void onPostExecute(String file_url) {
            // dismiss the dialog after getting all doctors
            pDialog.dismiss();

            // updating UI from Background Thread
            runOnUiThread(new Runnable() {
                public void run() {
                    /**
                     * Updating parsed JSON data into ListView
                     * */
                    ListAdapter adapter = new SimpleAdapter(AllDoctorActivity.this, doctorsList, R.layout.list_doctor, new String[]
                            {TAG_doctor_ID, TAG_NAME}, new int[]{R.id.doctor_ID, R.id.doctor_name});

                    // updating listview
                    setListAdapter(adapter);
                }
            });
        }
    }
}