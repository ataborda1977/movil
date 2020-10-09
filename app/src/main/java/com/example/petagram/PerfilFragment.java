package com.example.petagram;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class PerfilFragment extends Fragment {

    private List<Mascota> listaMascota;
    private ImageView imagenEstrella;
    private RecyclerView recyclerViewPerfil;
    private TextView textview;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vPerfil= inflater.inflate(R.layout.fragment_perfil, container, false);
        recyclerViewPerfil = ( RecyclerView ) vPerfil.findViewById(R.id.miRecyclerviewPerfil);

        //cargar Lista
        listaMascota = new ArrayList<Mascota>();
        //cargar datos
        cargarFotos();
        //mostrar Data
        recyclerViewPerfil.setHasFixedSize(true);
        recyclerViewPerfil.setLayoutManager(new GridLayoutManager(getContext(),3,RecyclerView.VERTICAL,false));
        iniciarAdaptadorPerfil();
        return vPerfil;
    }

    public void cargarFotos() {
        listaMascota.add(new Mascota("lucas", "5", R.drawable.dalmata1));
        listaMascota.add(new Mascota("Maya", "6", R.drawable.dalmata2));
        listaMascota.add(new Mascota("Candy", "7", R.drawable.dalmata3));
        listaMascota.add(new Mascota("Nacho", "8", R.drawable.dalmata4));
        listaMascota.add(new Mascota("Jlo", "2", R.drawable.dalmata5));
        listaMascota.add(new Mascota("Jlo", "2", R.drawable.dalmata6));
    }

    public void iniciarAdaptadorPerfil(){

        ListAdapter listAdapter = new ListAdapter(listaMascota,getContext());
        recyclerViewPerfil.setAdapter(listAdapter);


    }
}