package com.example.projet_marmiton_20;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class ApiInterface {

    public interface ApiInterfaceApplication{
        void onSuccess(ArrayList<Recette> songs);
        void onError(String message);
    }

    private String recette;
    private RequestQueue queue;

    private static final String TAG = "APP";

    public ApiInterface(RequestQueue queue, String re) {
        this.queue = queue;
        this.recette = re;
    }
    private final String URL = "https://api.spoonacular.com/recipes/search?apiKey=806171bec5aa4d00be74d2304fb7c6fb&?query="+ this.recette;


    public void getRecetteList(final ApiInterfaceApplication callback){

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.d(TAG, "onResponse: " + response);

                ListRecettes recettes = new ListRecettes();
                if(response.length() > 0){
                    for (int i = 0; i < response.length() ; i++) {
                        try {
                            JSONObject songObject = response.getJSONObject(i);
                            String title = songObject.getString("title");
                            int readyInMinutes = songObject.getInt("readyInMinutes");
                            String image = songObject.getString("image");

                            Recette re = new Recette(title,image,readyInMinutes);
                            recettes.add(re);

                        } catch (JSONException e) {
                            Log.d(TAG, "onResponse: " + e.getMessage());
                            callback.onError("Une erreur s'est produite");
                            e.printStackTrace();
                        }
                    }
                    callback.onSuccess(recettes);

                }else{
                    callback.onError("Aucune chanson trouvée");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "onResponse: " + error.getMessage());
                callback.onError("Une erreur s'est produite");
            }
        });

        queue.add(request);

    }
}
