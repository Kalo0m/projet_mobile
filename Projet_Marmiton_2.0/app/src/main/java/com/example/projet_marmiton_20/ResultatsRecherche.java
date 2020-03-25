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
import com.google.gson.JsonParser;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.koushikdutta.async.future.DoneCallback;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.future.ResponseFuture;

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
import java.util.concurrent.ExecutionException;


public class ResultatsRecherche extends AppCompatActivity {

    ListView liste;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultats_recherche);
        liste = findViewById(R.id.listView);
        txt = findViewById(R.id.resultat);
        Intent i1 = getIntent();
        txt.setText(i1.getStringExtra("nomRecette"));
        ArrayList<Recette> recettes = new ArrayList<>();
        JsonObject json = new JsonObject();
        try {
            json = Ion.with(this)
                .load("https://api.spoonacular.com/recipes/search?apiKey=806171bec5aa4d00be74d2304fb7c6fb&?query="+i1.getStringExtra("nomRecette"))
                .asJsonObject().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        JsonArray array = json.getAsJsonArray("results");
        for(int i=0;i<array.size();i++){
            JsonObject j = array.get(i).getAsJsonObject();
            Recette re = new Recette(j.get("title").getAsString(),j.get("image").getAsString(),j.get("readyInMinutes").getAsInt());
            recettes.add(re);
        }
        MyClassAdapter adapter = new MyClassAdapter(this,R.layout.activity_list_recette,recettes);
        liste.setAdapter(adapter);




        //MyClassAdapter adapter = new MyClassAdapter(ResultatsRecherche.this,R.layout.activity_list_recette,recettes);
        //liste.setAdapter(adapter);
        //JsonArray array = result.getAsJsonArray("results");
        //for(int i=0;i<array.size();i++){
        //    json[i]= (JsonObject) array.get(i);
        //}

    }


}















