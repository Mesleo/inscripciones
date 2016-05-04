package com.example.anonimo1.gestioninscriptions;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by anonimo1 on 04/05/2016.
 */
public class MainActivity extends AppCompatActivity {

    Intent intent;
    Bundle bundle;
    private ArrayList inscriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inscriptions_cities);

        GridView list = (GridView)findViewById(R.id.gridview);

        inscriptions = new ArrayList();
        annadirInscriptions();

        MyGridAdapter adapter = new MyGridAdapter(this,inscriptions);

        list.setAdapter(adapter);

    }

    private void annadirInscriptions() {

    }
}
