package com.example.projet_marmiton_20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;

public class PageAcceuil extends AppCompatActivity {

    EditText nomRecette;
    Spinner spinnerGenreRecette;
    SeekBar seekBarNombrePersonne;
    Button rechercher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nomRecette = findViewById(R.id.nomRecette);
        spinnerGenreRecette = findViewById(R.id.spinnerGenreRecette);
        seekBarNombrePersonne = findViewById(R.id.seekBarNombrePersonne);
        rechercher = findViewById(R.id.buttonRechcercher);

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
                if(seekBarNombrePersonne.getProgress()!=0){
                    intent.putExtra("nombrePersonne",seekBarNombrePersonne.getProgress());
                }
                startActivity(intent);
            }
        });

    }
}
