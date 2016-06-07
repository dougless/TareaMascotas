package com.mascotas.adaptador;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mascotas.pojo.Mascota;
import com.mascotas.R;

import java.util.ArrayList;

/**
 * Created by DESARROLLO2 on 30/05/2016.
 */
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotasLista;
    ArrayList<Mascota> favoritas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas,ArrayList<Mascota> favoritas,Activity activity){
        this.mascotasLista = mascotas;
        this.favoritas = favoritas;
        this.activity = activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);

        return new MascotaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder holder, int position) {
        final Mascota mascota = mascotasLista.get(position);

        holder.foto.setImageResource(mascota.getFoto());
        holder.nombre.setText(mascota.getNombre());
        holder.likes.setText(String.valueOf(mascota.getLikes()));
        holder.bLike.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(mascota.getLikes() < 1) {
                    mascota.setLikes(mascota.getLikes() + 1);
                    holder.likes.setText(String.valueOf(mascota.getLikes()));
                    ingresarFavoritos(mascota);
                }
            }
        });
    }

    public void ingresarFavoritos(Mascota mascota){
        if(favoritas.size()<6) {
            favoritas.add(mascota);
            System.out.println("--------------------se agregó favorita");
        }
        else {
            favoritas.remove(0);
            favoritas.add(mascota);
        }
    }

    @Override
    public int getItemCount() {
        return mascotasLista.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{
        private Button bLike;
        private ImageView foto;
        private TextView nombre;
        private TextView likes;

        public MascotaViewHolder(View itemView) {
           super(itemView);
           foto = (ImageView) itemView.findViewById(R.id.ivFoto);
           nombre = (TextView) itemView.findViewById(R.id.tvNombre);
           likes = (TextView) itemView.findViewById(R.id.tvLikes);
           bLike = (Button) itemView.findViewById(R.id.bLike);
       }
   }
}
