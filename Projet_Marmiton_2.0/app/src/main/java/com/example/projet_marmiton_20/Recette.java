package com.example.projet_marmiton_20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Recette extends AppCompatActivity {

    TextView nomRecette;
    ImageView imageRecette;
    TextView tempPreparation;
    TextView difficutle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recette);

        nomRecette = findViewById(R.id.nomRecette);
        imageRecette = findViewById(R.id.imageRecette);
        tempPreparation = findViewById(R.id.tempPreparation);
    }
}
