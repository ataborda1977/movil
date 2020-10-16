package com.example.petagram.fragments;

import com.example.petagram.adapter.ListaMascotaAdapter;
import com.example.petagram.pojo.Mascota;

import java.util.ArrayList;

public interface IRecyclerViewFragmentView {
    public void generarLinearLayoutVertical();
    public ListaMascotaAdapter crearAdaptador(ArrayList<Mascota> mascota);
    public void inicializarApadtadorRV(ListaMascotaAdapter adaptador);


}
