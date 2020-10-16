package com.example.petagram.fragments;

import com.example.petagram.adapter.ListAdapter;
import com.example.petagram.pojo.Mascota;

import java.util.ArrayList;

public interface IRecyclerViewFragmentView {
    public void generarLinearLayoutVertical();
    public ListAdapter crearAdaptador(ArrayList<Mascota> mascota);
    public void inicializarApadtadorRV(ListAdapter adaptador);


}
