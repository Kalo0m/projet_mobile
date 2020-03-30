package com.example.projet_marmiton_20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Recette extends AppCompatActivity {

    private String nomRecette;
    private String imageRecette;
    private int tempPreparation;
    private String id;
    private int nbpers;
    private int persrecette;

    public Recette(String titre, String img, int tps,String id, int nbpers, int persrecette){
        this.nomRecette=titre;
        this.imageRecette=img;
        this.tempPreparation=tps;
        this.id=id;
        this.nbpers=nbpers;
        this.persrecette=persrecette;
    }

    public Recette(String titre, int tps, String id, int nbpers, int persrecette){
        this.nomRecette=titre;
        this.tempPreparation=tps;
        this.id=id;
        this.nbpers=nbpers;
        this.persrecette=persrecette;
    }

    public int getnbpers(){
        return this.nbpers;
    }

    public int getPersrecette(){
        return this.persrecette;
    }

    public String getNomRecette() {
        return nomRecette;
    }

    public void setNomRecette(String nomRecette) {
        this.nomRecette = nomRecette;
    }

    public String getId(){
        return this.id;
    }


    public String getImageRecette() {
        return imageRecette;
    }

    public void setImageRecette(String imageRecette) {
        this.imageRecette = imageRecette;
    }

    public int getTempPreparation() {
        return tempPreparation;
    }

    public void setTempPreparation(int tempPreparation) {
        this.tempPreparation = tempPreparation;
    }

    @Override
    public String toString() {
        return "Recette{" +
                "nomRecette='" + nomRecette + '\'' +
                ", imageRecette='" + imageRecette + '\'' +
                ", tempPreparation=" + tempPreparation +
                '}';
    }
}
