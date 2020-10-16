package com.example.petagram;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.petagram.adapter.ListAdapter;
import com.example.petagram.pojo.Mascota;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class VotacionActivity2 extends AppCompatActivity {
    List<Mascota> listaMascota;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_votacion2);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


        initVotacion();


    }

    public void initVotacion(){
        listaMascota= new ArrayList<>();
        listaMascota.add(new Mascota("lucas","5",R.drawable.perro1));
        listaMascota.add(new Mascota("Maya","6",R.drawable.perro2));
        listaMascota.add(new Mascota("Candy","7",R.drawable.perro3));
        listaMascota.add(new Mascota("Nacho","8",R.drawable.perro4));
        listaMascota.add(new Mascota("Jlo","2",R.drawable.perro5));

        Collections.sort(listaMascota, new Comparator<Mascota>(){
            @Override
            public int compare(Mascota o1, Mascota o2) {
              //  return o1.getCantidadLike().compareToIgnoreCase(o2.getCantidadLike());
                return Integer.parseInt(o1.getCantidadLike()) >  Integer.parseInt(o2.getCantidadLike()) ? -1 : (Integer.parseInt(o1.getCantidadLike())< Integer.parseInt(o2.getCantidadLike())) ? 1 : 0;
            }
        });

        ListAdapter listAdapter = new ListAdapter(listaMascota,this);
        RecyclerView recyclerView = findViewById(R.id.resRecyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);


    }
}