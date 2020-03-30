package com.example.projet_marmiton_20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class PageAcceuil extends AppCompatActivity {

    EditText nomRecette;
    Spinner spinnerGenreRecette;
    Spinner spinner;
    Button rechercher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nomRecette = findViewById(R.id.nomRecette);
        spinnerGenreRecette = findViewById(R.id.spinnerGenreRecette);
        spinner = findViewById(R.id.spinner);
        rechercher = findViewById(R.id.buttonRechcercher);
        List<String> cuisine = new ArrayList<>();
        cuisine.add("");
        cuisine.add("African");
        cuisine.add("American");
        cuisine.add("British");
        cuisine.add("Cajun");
        cuisine.add("Caribbean");
        cuisine.add("Chinese");
        cuisine.add("Eastern European");
        cuisine.add("European");
        cuisine.add("French");
        cuisine.add("German");
        cuisine.add("Greek");
        cuisine.add("Indian");
        cuisine.add("Irish");
        cuisine.add("Italian");
        cuisine.add("Japanese");
        cuisine.add("Jewish");
        cuisine.add("Korean");
        cuisine.add("Latin American");
        cuisine.add("Mediterranean");
        cuisine.add("Mexican");
        cuisine.add("Middle Eastern");
        cuisine.add("Nordic");
        cuisine.add("Southern");
        cuisine.add("Spanish");
        cuisine.add("Thai");
        cuisine.add("Vietnamese");
        ArrayAdapter<String> adap = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,cuisine);
        spinnerGenreRecette.setAdapter(adap);
        List<Integer> nb = new ArrayList<>();
        nb.add(new Integer(1));
        nb.add(new Integer(2));
        nb.add(new Integer(3));
        nb.add(new Integer(4));
        nb.add(new Integer(6));
        nb.add(new Integer(8));
        nb.add(new Integer(16));
        nb.add(new Integer(32));
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this,android.R.layout.simple_spinner_item,nb);
        spinner.setAdapter(adapter);
        rechercher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PageAcceuil.this,ResultatsRecherche.class);
                if(nomRecette.getText()!=null){
                    intent.putExtra("nomRecette",nomRecette.getText().toString());
                }
                if(spinnerGenreRecette.getSelectedItem()!=null){
                    intent.putExtra("genreRecette",spinnerGenreRecette.getSelectedItem().toString());
                }
                if(spinner.getSelectedItem() != null){
                    intent.putExtra("nombrePersonne",new Integer((Integer) spinner.getSelectedItem()));
                }
                startActivity(intent);
            }
        });

    }
}
