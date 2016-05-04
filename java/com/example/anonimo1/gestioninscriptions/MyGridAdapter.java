package com.example.anonimo1.gestioninscriptions;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by anonimo1 on 04/05/2016.
 */
public class MyGridAdapter extends BaseAdapter{

    Activity activity;
    ArrayList inscriptions;
    ActivityInscriptionsCity aic;

    public MyGridAdapter(MainActivity mainActivity, ArrayList inscriptions) {
        this.activity = mainActivity;
        this.inscriptions = inscriptions;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View converView, ViewGroup viewGroup) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.inscriptions_city_item, null, true);
//        aic.
//
//        ImageView image = (ImageView) view.findViewById(R.id.city_image);
//        image.setImageResource(currentSitio.getImagen());
//
//        TextView tvSitio = (TextView) view.findViewById(R.id.tvSitio);
//        tvSitio.setText(currentSitio.getTitulo());
//
//        TextView tvDescripcion = (TextView) view.findViewById(R.id.tvDescripcion);
//        tvDescripcion.setText(currentSitio.getDescripcion().substring(0, 50) + "...");
//
//        final LinearLayout linearElement = (LinearLayout) view.findViewById(R.id.linearElement);
//        linearElement.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                intent = new Intent(activity, MostrarSitio.class);
//                intent.putExtra("SITIO", currentSitio);
//                activity.startActivity(intent);
//            }
//        });

        return null;
    }
}
