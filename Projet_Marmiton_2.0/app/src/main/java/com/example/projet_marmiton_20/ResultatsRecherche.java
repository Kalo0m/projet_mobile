package com.example.projet_marmiton_20;

import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "APP";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSongList(n);
    }

    public void getSongList(String n){
        RequestQueue queue = VolleySingleton.getInstance(this).getRequestQueue();
        ApiInterface request = new ApiInterface(queue,n);

        request.getRecetteList(new ApiInterface.ApiInterfaceApplication() {
            @Override
            public void onSuccess(ArrayList<Recette> songs) {

            }

            @Override
            public void onError(String message) {
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}















    class MyClassAdapter extends ArrayAdapter<Recette> {
        LayoutInflater inflater;
        public MyClassAdapter(Context context, int textViewResourceId, ListRecettes items) {
            super(context, textViewResourceId ,items.getRecettes());
            inflater = LayoutInflater.from(context);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Recette recette = getItem(position);
            View row = inflater.inflate(R.layout.activity_list_recette,parent,false);
            LayoutInflater inflater = LayoutInflater.from(getContext());
            TextView Titre = (TextView)row.findViewById(R.id.textView);
            TextView Temps = (TextView)row.findViewById(R.id.textView2);
            ImageView img = (ImageView) row.findViewById(R.id.imageView);
            Titre.setText(recette.getNomRecette());
            Temps.setText(recette.getTempPreparation());
            return(row);
        }
    }




    /*JsonArray array = (JsonArray) result.get("results");
                        for(int i=0;i<array.size();i++){
        JsonObject json = (JsonObject) array.get(i);
        Recette re = new Recette(json.get("title").getAsString(),json.get("image").getAsString(),json.get("readyInMinutes").getAsInt());
        recettes.add(re);
        }*/
