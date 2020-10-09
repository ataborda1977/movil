package com.example.petagram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.petagram.adapter.PageAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    TabLayout tablayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.miBarra);
        tablayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viePager);
        tablayout.addTab(tablayout.newTab().setText("Listado Mascotas"));
        tablayout.addTab(tablayout.newTab().setText("Perfil"));

        if (toolbar!=null){
            setSupportActionBar(toolbar);
        }

        setupViewPage();

       // init();

       /* imagenEstrella = (ImageView) findViewById(R.id.lnkVerFav);

        imagenEstrella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, VotacionActivity2.class);
                startActivity(intent);
            }
        });*/
    }

    private ArrayList<Fragment> agregarFragmentos(){
        ArrayList<Fragment> fragments = new ArrayList<Fragment>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());

        return fragments;

    }

    private void setupViewPage(){
            viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragmentos()));
            viewPager.setOffscreenPageLimit(2);
            tablayout.setupWithViewPager(viewPager);
            tablayout.getTabAt(0).setIcon(R.drawable.ic_action_home);
            tablayout.getTabAt(1).setIcon(R.drawable.ic_action_perfil);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       // return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.mContacto :
                Intent intent = new Intent(this,ActivityContacto.class);
                startActivity(intent);

                break;
            case R.id.mAbout:
                Intent intent2 = new Intent(this,ActivityDesarrollo.class);
                startActivity(intent2);

                break;


        }



        return super.onOptionsItemSelected(item);

    }

    /*public void init(){
        listaMascota= new ArrayList<>();
        listaMascota.add(new Mascota("lucas","5",R.drawable.perro1));
        listaMascota.add(new Mascota("Maya","6",R.drawable.perro2));
        listaMascota.add(new Mascota("Candy","7",R.drawable.perro3));
        listaMascota.add(new Mascota("Nacho","8",R.drawable.perro4));
        listaMascota.add(new Mascota("Jlo","2",R.drawable.perro5));

        ListAdapter listAdapter = new ListAdapter(listaMascota,this);
        RecyclerView recyclerView = findViewById(R.id.miRecyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);


    }*/

}