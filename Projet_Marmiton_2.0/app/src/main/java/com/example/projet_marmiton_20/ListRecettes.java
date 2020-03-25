package com.example.projet_marmiton_20;

import java.util.ArrayList;

public class ListRecettes {

ArrayList<Recette> recettes;

public ListRecettes(){
    this.recettes = new ArrayList<Recette>();
}

public void add(Recette re){
    this.recettes.add(re);
}

public void remove(Recette re ){
    this.recettes.remove(re);
}

public ArrayList<Recette> getRecettes(){
    return recettes;
}

    @Override
    public String toString() {
        return "ListRecettes{" +
                "recettes=" + recettes +
                '}';
    }
}
