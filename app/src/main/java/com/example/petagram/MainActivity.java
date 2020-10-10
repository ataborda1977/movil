package com.example.petagram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.petagram.adapter.PageAdapter;
import com.example.petagram.fragments.PerfilFragment;
import com.example.petagram.fragments.RecyclerViewFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

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



}