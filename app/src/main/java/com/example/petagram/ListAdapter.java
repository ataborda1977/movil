package com.example.petagram;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petagram.pojo.Mascota;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<Mascota> mData;
    private LayoutInflater mlFlater;
    private Context context;

    public ListAdapter(List<Mascota> itemList,Context context){
        this.mlFlater = LayoutInflater.from(context);
        this.context=context;
        this.mData=itemList;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = mlFlater.inflate(R.layout.cardviewmascota,null);

        return new ListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListAdapter.ViewHolder holder,final int position) {
        holder.binData(mData.get(position));

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imagenMascota;
        TextView nombreMascota,cantidadLike;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagenMascota=itemView.findViewById(R.id.imagenMascota);
            nombreMascota=itemView.findViewById(R.id.tvNombreMascota);
            cantidadLike=itemView.findViewById(R.id.tvcantidadLike);

        }
        void binData(final Mascota item){
            imagenMascota.setImageResource(item.getImagen());
            nombreMascota.setText(item.getNombreMascota());
            cantidadLike.setText(item.getCantidadLike());
        }
    }
}
