package com.example.bublly.bemedisure;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;

/**
 * Created by BUBLLY on 16-09-2016.
 */
public class API_Connector
{
    public JSONArray getDoctorList()
    {
        //url of the doctor_list.php file

        String url = "http://sanjay.com/doctor_list.php";

        HttpEntity httpEntity = null;

        try
        {
            DefaultHttpClient httpClient = new DefaultHttpClient();

            HttpGet httpGet = new HttpGet(url);

            HttpResponse httpResponse = httpClient.execute(httpGet);

            httpEntity = httpResponse.getEntity();
        }
        catch(ClientProtocolException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        JSONArray jsonArray = null;

        if(httpEntity != null)
        {
            try
            {
                String entityResponse = EntityUtils.toString(httpEntity);
                Log.e("Entity Response  : " , entityResponse);
                jsonArray = new JSONArray(entityResponse);
            }
            catch(JSONException e)
            {
                e.printStackTrace();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        return jsonArray;
    }
}
