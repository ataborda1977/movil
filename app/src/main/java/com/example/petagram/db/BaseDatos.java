package com.example.petagram.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.petagram.pojo.Mascota;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {
    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null,ConstantesBaseDatos.DATABASE_VERSION);
        this.context=context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTabla= "CREATE table  "+ConstantesBaseDatos.TABLE_MASCOTA+"("+
                 ConstantesBaseDatos.TABLE_MASCOTA_ID+" INTEGER PRIMARY KEY AUTOINCREMENT "+","+
                ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE+ " TEXT, "+
                ConstantesBaseDatos.TABLE_MASCOTA_IMAGEN+ " INTEGER, "+
                ConstantesBaseDatos.TABLE_MASCOTA_CANTIDAD_LIKE+ " INTEGER "+
                ")";

        db.execSQL(queryCrearTabla);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS  "+ConstantesBaseDatos.TABLE_MASCOTA );
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerListaMascotas(){
        ArrayList<Mascota> listaMascotas= new ArrayList<Mascota>();
        String sqlConsulta= "Select * from "+ConstantesBaseDatos.TABLE_MASCOTA;
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor registros = db.rawQuery(sqlConsulta,null);
        while(registros.moveToNext()){
            Mascota mascotaDB = new Mascota();
            mascotaDB.setId(registros.getInt(0));
            mascotaDB.setNombreMascota(registros.getString(1));
            mascotaDB.setImagen(registros.getInt(2));
            mascotaDB.setCantidadLike(registros.getString(3));

            listaMascotas.add(mascotaDB);

        }

        db.close();
        return listaMascotas;
    }

    public void insertarMascotas(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(ConstantesBaseDatos.TABLE_MASCOTA,null,contentValues);
        db.close();


    }

    public void actualizarCantidadLikeDB(ContentValues contentValues,Mascota mascota){
        SQLiteDatabase db = this.getWritableDatabase();
        db.update(ConstantesBaseDatos.TABLE_MASCOTA,contentValues,ConstantesBaseDatos.TABLE_MASCOTA_ID+"=?",
                new String[]{String.valueOf(mascota.getId())});
        db.close();
    }

    public Mascota consultarMascotaDBxID (int idMascota){
        SQLiteDatabase db = this.getWritableDatabase();
        int cantidadLike=0;
        Cursor registroDB = db.rawQuery("Select * from "+ConstantesBaseDatos.TABLE_MASCOTA+ " where id= "+idMascota+ "",null );
        if(registroDB!=null) {
            registroDB.moveToFirst();
        }

        Mascota mascotaDB = new Mascota(registroDB.getString(1),registroDB.getString(3),registroDB.getInt(2) );
        db.close();
        return mascotaDB;

    }

}
