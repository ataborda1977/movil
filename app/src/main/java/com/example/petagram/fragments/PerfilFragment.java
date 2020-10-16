package com.example.petagram.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.petagram.adapter.ListaMascotaAdapter;
import com.example.petagram.R;
import com.example.petagram.pojo.Mascota;
import com.example.petagram.presentador.IRecyclerViewFragmentPresenter;
import com.example.petagram.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;


public class PerfilFragment extends Fragment implements IRecyclerViewFragmentView{


    private RecyclerView recyclerViewPerfil;
    private IRecyclerViewFragmentPresenter presenter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vPerfil= inflater.inflate(R.layout.fragment_perfil, container, false);
        recyclerViewPerfil = ( RecyclerView ) vPerfil.findViewById(R.id.miRecyclerviewPerfil);
        presenter = new RecyclerViewFragmentPresenter(this,getContext());
        return vPerfil;

    }




    @Override
    public void generarLinearLayoutVertical() {
        GridLayoutManager gridLayout = new GridLayoutManager(getContext(),3);
        recyclerViewPerfil.setLayoutManager(gridLayout);

    }

    @Override
    public ListaMascotaAdapter crearAdaptador(ArrayList<Mascota> mascota) {
        ListaMascotaAdapter listaMascotaAdapter = new ListaMascotaAdapter(mascota,getContext());
        return listaMascotaAdapter;
    }

    @Override
    public void inicializarApadtadorRV(ListaMascotaAdapter adaptador) {
        recyclerViewPerfil.setAdapter(adaptador);
    }
}