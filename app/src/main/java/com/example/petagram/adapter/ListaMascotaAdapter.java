package com.example.petagram.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.petagram.DetalleMascotaActivity;
import com.example.petagram.R;
import com.example.petagram.db.ConstructorMascotas;
import com.example.petagram.pojo.Mascota;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class ListaMascotaAdapter extends RecyclerView.Adapter<ListaMascotaAdapter.MascotaViewHolder> {
    private List<Mascota> mData;
    private LayoutInflater mlFlater;
    private Context context;
    private ViewPager mViewPager;
    private TabLayout tabLayout;
    public ListaMascotaAdapter(List<Mascota> itemList, Context context){
        this.mlFlater = LayoutInflater.from(context);
        this.context=context;
        this.mData=itemList;

    }
    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = mlFlater.inflate(R.layout.cardviewmascota,null);
        return new MascotaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder,final int position) {
        //holder.binData(mData.get(position));
        final Mascota mascota = mData.get(position);
        mascotaViewHolder.imagenMascota.setImageResource(mascota.getImagen());
        mascotaViewHolder.nombreMascota.setText(mascota.getNombreMascota());
        mascotaViewHolder.cantidadLike.setText(mascota.getCantidadLike()+" Like");

        mascotaViewHolder.imagenMascota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context ,"Click en Imagen "+ mascota.getNombreMascota(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, DetalleMascotaActivity.class);
                intent.putExtra("IdMascota",mascota.getId());
                context.startActivity(intent);

                /*FragmentManager fragmentManager = ((FragmentActivity) v.getContext()).getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fg1,new PerfilFragment());
                fragmentTransaction.commit();
                */

            }
        });

        mascotaViewHolder.imagenHuesoBlanco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context ,"Like para Mascota "+ mascota.getNombreMascota(),Toast.LENGTH_SHORT).show();
                ConstructorMascotas constructorMascotas= new ConstructorMascotas(context);
                constructorMascotas.actualizarMascotaCantidadLike(mascota);
                Mascota consultaMascota= constructorMascotas.consultarMascotaxID(mascota.getId());
                mascotaViewHolder.cantidadLike.setText(consultaMascota.getCantidadLike()+" Like");

            }
        });

        mascotaViewHolder.imagenHuesoYellowQuitarLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context ,"Quitar Like para Mascota "+ mascota.getNombreMascota(),Toast.LENGTH_SHORT).show();
                ConstructorMascotas constructorMascotas= new ConstructorMascotas(context);
                constructorMascotas.actualizarMascotaQuitarCantidadLike(mascota);
                Mascota consultaMascota= constructorMascotas.consultarMascotaxID(mascota.getId());
                mascotaViewHolder.cantidadLike.setText(consultaMascota.getCantidadLike()+" Like");


            }
        });


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MascotaViewHolder extends RecyclerView.ViewHolder {
        ImageView imagenMascota;
        TextView nombreMascota;
        TextView cantidadLike;
        ImageView imagenHuesoBlanco;
        ImageView imagenHuesoYellowQuitarLike;


        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imagenMascota=itemView.findViewById(R.id.imagenMascota);
            nombreMascota=itemView.findViewById(R.id.tvNombreMascota);
            cantidadLike=itemView.findViewById(R.id.tvcantidadLike);
            imagenHuesoBlanco=itemView.findViewById(R.id.imagenhuesito1);
            imagenHuesoYellowQuitarLike = itemView.findViewById(R.id.imagenhuesito2);
        }

    }
}
