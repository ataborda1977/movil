package com.example.petagram.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.petagram.ListAdapter;
import com.example.petagram.R;
import com.example.petagram.pojo.Mascota;

import java.util.ArrayList;
import java.util.List;


public class RecyclerViewFragment extends Fragment {
    private List<Mascota> listaMascota;
    private ImageView imagenEstrella;
    private RecyclerView recyclerView;
    private TextView textview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        recyclerView = ( RecyclerView ) v.findViewById(R.id.miRecyclerview);
        //cargar Lista
        listaMascota = new ArrayList<Mascota>();
        //cargar datos
        cargarDatos();
        //mostrar Data
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        iniciarAdaptador();

        // Inflate the layout for this fragment
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    public void cargarDatos() {
        listaMascota.add(new Mascota("lucas", "5", R.drawable.perro1));
        listaMascota.add(new Mascota("Maya", "6", R.drawable.perro2));
        listaMascota.add(new Mascota("Candy", "7", R.drawable.perro3));
        listaMascota.add(new Mascota("Nacho", "8", R.drawable.perro4));
        listaMascota.add(new Mascota("Jlo", "2", R.drawable.perro5));
    }

    public void iniciarAdaptador(){

        ListAdapter listAdapter = new ListAdapter(listaMascota,getContext());
        recyclerView.setAdapter(listAdapter);


    }
}