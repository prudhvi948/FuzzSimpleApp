package com.prudhvi.fuzzsimpleapp.services;

import android.os.AsyncTask;
import android.util.Log;

import com.prudhvi.fuzzsimpleapp.App;
import com.prudhvi.fuzzsimpleapp.R;
import com.prudhvi.fuzzsimpleapp.models.Data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by prudhvi on 4/11/2015.
 * Gets the JSON data from the server, parses it and saves it in an ArrayList.
 * If the server doesn't respond, this service uses the local file with the
 * same JSON data.
 */
public class NetworkOperation extends AsyncTask<String, Void, ArrayList<Data>> {

    @Override
    protected ArrayList<Data> doInBackground(String... params) {
        String response = null;
        ArrayList<Data> dataArrayList = null;
        try {
            URL url = new URL(params[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            if(connection.getResponseCode() == 200) { //Only if the HTTP code is 200
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                        (InputStream) (connection.getContent())));
                StringBuilder jsonData = new StringBuilder();
                while ((response = bufferedReader.readLine()) != null) {
                    jsonData.append(response);
                }
                response = jsonData.toString();
            }
            else { //If server doesn't respond, get the JSON data from locally saved file
                response = loadDataFile();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        dataArrayList = getDataArray(response);
        return dataArrayList;
    }

    @Override
    protected void onPostExecute(ArrayList<Data> result) {

    }

    /*Reads the JSON data from the locally saved file and returns it as string*/
    private static String loadDataFile() throws IOException
    {
        InputStream inputStream = App.getContext().getResources().openRawResource(R.raw.data);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String receiveString;
        StringBuilder stringBuilder = new StringBuilder();

        while ((receiveString = bufferedReader.readLine()) != null )
        {
            stringBuilder.append(receiveString);
            stringBuilder.append("\n");
        }

        bufferedReader.close();
        inputStreamReader.close();
        inputStream.close();

        return stringBuilder.toString();
    }

    /*Parses the JSON string and stores each object in ArrayList*/
    private ArrayList<Data> getDataArray(String response) {
        ArrayList<Data> arrayList = new ArrayList<Data>();
        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(response);
            for(int i=0; i<jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Data data = new Data(jsonObject);
                arrayList.add(data);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}
