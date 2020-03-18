package com.example.projet_marmiton_20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.json.JSONArray;
import org.json.JSONException;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ResultatsRecherche extends AppCompatActivity {

    ListView listView;
    TextView nomrecette;
    String recettes;
    List<String> res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultats_recherche);

        listView = findViewById(R.id.listView);
        nomrecette.findViewById(R.id.resultat);

        Intent intent = getIntent();
        String recette = intent.getStringExtra("nomRecette");
        nomrecette.setText("Résultats pour: "+recette);

        Ion.with(this)
                .load("https://api.spoonacular.com/recipes/search?query=" +recette)
                .asString()
                .setCallback(new FutureCallback<String>() {
                    @Override
                    public void onCompleted(Exception e, String result) {
                        recettes = result;
                        try {
                            res = new ArrayList<>();
                            JSONArray jsonArray = new JSONArray(recettes);
                            for(int i = 0;i<jsonArray.length();i++){
                                res.add(jsonArray.get(i).toString());
                            }

                        } catch (JSONException e1) {
                            e1.printStackTrace();
                        }
                        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, res);
                        System.out.println(res);
                        listView.setAdapter(itemsAdapter);
                    }
                });

    }
}
