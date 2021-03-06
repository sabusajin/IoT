package edu.uncc.dauti.ninersense_new;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Sajin S on 10/27/2016.
 */

public class SecuritySystemAsyncTask extends AsyncTask<String, Void, String>
{


    @Override
    protected String doInBackground(String... params) {
        String str = params[0];
        Log.d("abcd",str);
        //Toast.makeText(SecuritySystemAsyncTask.this,params[0],Toast.LENGTH_SHORT);
        String result = "";
        URL url = null;
        try {
            url = new URL("http://192.168.1.2/security.php");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            String data = "security=" + str;
            urlConnection.setRequestMethod("POST");
            urlConnection.setDoOutput(true);
            urlConnection.getOutputStream().write(data.getBytes("UTF-8"));
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            result = sb.toString().trim();
            Log.d("result", result);


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //http postappSpinners
        return result;
    }
    }

