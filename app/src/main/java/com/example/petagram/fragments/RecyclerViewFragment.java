package com.example.petagram.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
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


public class RecyclerViewFragment extends Fragment implements  IRecyclerViewFragmentView{
    private RecyclerView recyclerView;
    private IRecyclerViewFragmentPresenter presenter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        recyclerView = ( RecyclerView ) v.findViewById(R.id.miRecyclerview);
        presenter = new RecyclerViewFragmentPresenter(this,getContext());
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(llm);
        recyclerView.setHasFixedSize(true);
    }

    @Override
    public ListaMascotaAdapter crearAdaptador(ArrayList<Mascota> mascota) {
        ListaMascotaAdapter listaMascotaAdapter = new ListaMascotaAdapter(mascota,getContext());
        recyclerView.setAdapter(listaMascotaAdapter);
        return listaMascotaAdapter;
    }

    @Override
    public void inicializarApadtadorRV(ListaMascotaAdapter adaptador) {
        recyclerView.setAdapter(adaptador);
    }

}