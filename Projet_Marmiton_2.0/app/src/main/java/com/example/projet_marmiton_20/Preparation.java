package com.example.projet_marmiton_20;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.ion.Ion;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class Preparation extends AppCompatActivity {

    ImageView image;
    TextView name;
    TextView temps;
    TextView preparation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recette);
        image = findViewById(R.id.imageRecette);
        name = findViewById(R.id.nomRecette);
        temps = findViewById(R.id.tempPreparation);
        preparation = findViewById(R.id.recette);
        Picasso.get().load("https://spoonacular.com/recipeImages/"+getIntent().getStringExtra("image")).into(image);
        name.setText(getIntent().getStringExtra("name"));
        int a = 0;
        temps.setText(""+getIntent().getIntExtra("time",a)+"min");
        System.out.println(getIntent().getStringExtra("id"));
        JsonObject json = new JsonObject();
        try {
            json = Ion.with(this)
                    .load("https://api.spoonacular.com/recipes/"+getIntent().getStringExtra("id")+"/ingredientWidget.json")
                    .asJsonObject().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(json);



    }

}
