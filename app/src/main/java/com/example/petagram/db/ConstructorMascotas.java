package com.example.petagram.db;

import android.content.ContentValues;
import android.content.Context;

import com.example.petagram.R;
import com.example.petagram.pojo.Mascota;

import java.util.ArrayList;

public class ConstructorMascotas {

    private Context context;

    public ConstructorMascotas(Context context){
        this.context=context;

    }


    public ArrayList<Mascota> obtenerDatos(){
       // return obtenerDatosDummy();

        /*consultar Mascotas de la Base de datos*/
        BaseDatos db = new BaseDatos(context);
        insertarMascotasBD(db);
        return db.obtenerListaMascotas();

    }

    /*metodos para actualizar cantidad de like*/
    public void actualizarMascotaCantidadLike(Mascota mascota){
        ContentValues contentValues = new ContentValues();
        int cantidad=0;
        String cantLike = mascota.getCantidadLike();
        cantidad = Integer.parseInt(cantLike);
        cantidad = cantidad +1;
        BaseDatos db = new BaseDatos(context);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_CANTIDAD_LIKE,cantidad);
        db.actualizarCantidadLikeDB(contentValues,mascota);

    }
    /*metodos para quitar cantidad de like*/
    public void actualizarMascotaQuitarCantidadLike(Mascota mascota){
        ContentValues contentValues = new ContentValues();
        int cantidad=0;
        String cantLike = mascota.getCantidadLike();
        cantidad = Integer.parseInt(cantLike);
        cantidad = cantidad -1;
        if (cantidad < 0) {
            cantidad = 0;
        }

        BaseDatos db = new BaseDatos(context);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_CANTIDAD_LIKE,cantidad);
        db.actualizarCantidadLikeDB(contentValues,mascota);

    }

    /*metodos para consultar una mascoda por su IDMascota */
    public Mascota consultarMascotaxID(int idMascota){
        BaseDatos db = new BaseDatos(context);
        return db.consultarMascotaDBxID(idMascota);
    }

    /*metodo para adicionar varias mascotas a la base de datos*/
    public void insertarMascotasBD(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE,"Candy");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_IMAGEN,R.drawable.perro1);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_CANTIDAD_LIKE,"5");
        db.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE,"Maya");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_IMAGEN,R.drawable.perro2);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_CANTIDAD_LIKE,"7");
        db.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE,"Nacho");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_IMAGEN,R.drawable.perro3);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_CANTIDAD_LIKE,"3");
        db.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE,"Jlo");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_IMAGEN,R.drawable.perro4);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_CANTIDAD_LIKE,"9");
        db.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE,"Lucas");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_IMAGEN,R.drawable.perro5);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_CANTIDAD_LIKE,"6");
        db.insertarMascotas(contentValues);

    }

    /*metodo test mascotas en memoria */
    public ArrayList<Mascota> obtenerDatosDummy(){
        ArrayList<Mascota> listaMascota = new ArrayList<Mascota>();

        listaMascota.add(new Mascota("lucas", "5", R.drawable.perro1));
        listaMascota.add(new Mascota("Maya", "6", R.drawable.perro2));
        listaMascota.add(new Mascota("Candy", "7", R.drawable.perro3));
        listaMascota.add(new Mascota("Nacho", "8", R.drawable.perro4));
        listaMascota.add(new Mascota("Jlo", "2", R.drawable.perro5));

        return listaMascota;

    }
}
