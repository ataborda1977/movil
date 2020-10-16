package com.example.petagram.presentador;

import android.content.Context;

import com.example.petagram.adapter.ListAdapter;
import com.example.petagram.db.ConstructorMascotas;
import com.example.petagram.fragments.IRecyclerViewFragmentView;
import com.example.petagram.pojo.Mascota;

import java.util.ArrayList;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerMascotasBaseDatos();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        this.mascotas= constructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iRecyclerViewFragmentView.inicializarApadtadorRV(iRecyclerViewFragmentView.crearAdaptador(this.mascotas));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();

    }


}

