package com.example.anonimo1.gestioninscriptions;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;


public class ActivityInscriptionsCity extends ListActivity {

    // URL to get contacts JSON
    private static String url = "http://192.168.1.66:9999/api/v1/inscripciones/noleidas";

    // JSON Node names
    private static final String TAG_STUDENTINFO = "inscripciones";
    private static final String TAG_NAME = "nombre";
    private static final String TAG_CITY = "ciudad";
    private static final String TAG_EMAIL = "correo";
    private static final String TAG_PHONE = "telefono";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_inscriptions_city);

        // Calling async task to get json
        new getInscriptions().execute();
    }

    /**
     * Async task class to get json by making HTTP call
     */
    private class getInscriptions extends AsyncTask<Void, Void, Void> {

        // Hashmap for ListView
        ArrayList<HashMap<String, String>> inscriptionsList;
        ProgressDialog pDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(ActivityInscriptionsCity.this);
            pDialog.setMessage("Espera por favor...");
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            // Creating service handler class instance
            WebRequest webreq = new WebRequest();

            // Making a request to url and getting response
            String jsonStr = webreq.makeWebServiceCall(url, WebRequest.GET);

            Log.d("Response: ", "> " + jsonStr);

            inscriptionsList = parseJSON(jsonStr, "Córdoba");

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();
            /**
             * Updating parsed JSON data into ListView
             * */
            if (inscriptionsList != null) {
                ListAdapter adapter = new SimpleAdapter(
                        ActivityInscriptionsCity.this, inscriptionsList,
                        R.layout.list_inscriptions_item, new String[]{TAG_NAME
                        , TAG_EMAIL
                        , TAG_PHONE
                }, new int[]{R.id.name
                        , R.id.email
                        , R.id.mobile
                });
                setListAdapter(adapter);
            }
        }

    }

    private ArrayList<HashMap<String, String>> parseJSON(String json, String ciudad) {
        if (json != null) {
            try {
                // Hashmap for ListView
                ArrayList<HashMap<String, String>> inscriptionsList = new ArrayList<HashMap<String, String>>();

                JSONObject jsonObj = new JSONObject(json);

                // Getting JSON Array node
                JSONArray inscriptions = jsonObj.getJSONArray(TAG_STUDENTINFO);

                // looping through All Students
                for (int i = 0; i < inscriptions.length(); i++) {
                    JSONObject c = inscriptions.getJSONObject(i);

//                    String id = c.getString(TAG_ID);
                    String name = c.getString(TAG_NAME);
                    String email = c.getString(TAG_EMAIL);
                    String phone = c.getString(TAG_PHONE);
                    String city = c.getString(TAG_CITY);

                    // tmp hashmap for single student
                    HashMap<String, String> inscription = new HashMap<String, String>();

                    // adding each child node to HashMap key => value
//                    student.put(TAG_ID, id);
                    if(city.equals(ciudad)) {
                        inscription.put(TAG_NAME, name);
                        inscription.put(TAG_EMAIL, email);
                        inscription.put(TAG_PHONE, phone);
                        inscriptionsList.add(inscription);
                    }

                    // adding student to students list
                }
                return inscriptionsList;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            Log.e("ServiceHandler", "Couldn't get any data from the url");
            return null;
        }
    }


}
