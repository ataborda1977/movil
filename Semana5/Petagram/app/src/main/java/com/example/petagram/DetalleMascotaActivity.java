package com.example.petagram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.petagram.db.ConstructorMascotas;
import com.example.petagram.pojo.Mascota;
import com.mikhaellopez.circularimageview.CircularImageView;

public class DetalleMascotaActivity extends AppCompatActivity {

    int idMascota;
    CircularImageView circularImageView;
    TextView textViewDetNombreAnimal;
    TextView textViewDetCantidadLike;
    Toolbar toolbar;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_mascota);

       circularImageView=findViewById(R.id.detImagen);
       textViewDetNombreAnimal=findViewById(R.id.tvdetNombreMascota);
       textViewDetCantidadLike=findViewById(R.id.tvdetCantLike);
       toolbar = (Toolbar) findViewById(R.id.miBarra);

       if (toolbar!=null){
           setSupportActionBar(toolbar);
       }

       Bundle bundle=getIntent().getExtras();
       if(bundle!=null)
           idMascota=bundle.getInt("IdMascota");

       ConstructorMascotas constructorMascotas= new ConstructorMascotas(this);
       Mascota consultaMascota= constructorMascotas.consultarMascotaxID(idMascota);


       circularImageView.setImageResource(consultaMascota.getImagen());
       textViewDetNombreAnimal.setText("Mascota: "+consultaMascota.getNombreMascota());
       textViewDetCantidadLike.setText(consultaMascota.getCantidadLike()+" Likes");

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