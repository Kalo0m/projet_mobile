package com.example.projet_marmiton_20;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class MyClassAdapter extends ArrayAdapter<Recette> {

    LayoutInflater inflater;
    public MyClassAdapter(Context context, int textViewResourceId, ArrayList<Recette> items) {
        super(context, textViewResourceId ,items);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Recette recette = getItem(position);
        View row = inflater.inflate(R.layout.activity_list_recette,parent,false);
        LayoutInflater inflater = LayoutInflater.from(getContext());
        TextView titre = (TextView)row.findViewById(R.id.textView);
        TextView temps = (TextView)row.findViewById(R.id.textView2);
        ImageView img = (ImageView) row.findViewById(R.id.imageView);
        titre.setText(recette.getNomRecette());
        temps.setText(recette.getTempPreparation()+"");
        return(row);
    }

}
