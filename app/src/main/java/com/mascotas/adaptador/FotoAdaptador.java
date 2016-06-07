package com.mascotas.adaptador;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mascotas.R;
import com.mascotas.pojo.Foto;
import com.mascotas.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by DESARROLLO2 on 7/06/2016.
 */
public class FotoAdaptador  extends RecyclerView.Adapter<FotoAdaptador.FotoViewHolder> {

    ArrayList<Foto> fotosLista;
    Activity activity;

    public FotoAdaptador(ArrayList<Foto> fotos,Activity activity){
        this.fotosLista = fotos;
        this.activity = activity;
    }

    @Override
    public FotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_foto, parent, false);

        return new FotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final FotoViewHolder holder, int position) {
        final Foto foto = fotosLista.get(position);

        holder.foto.setImageResource(foto.getFoto());
        holder.likes.setText(String.valueOf(foto.getLikes()));
    }

    @Override
    public int getItemCount() {
        return fotosLista.size();
    }

    public static class FotoViewHolder extends RecyclerView.ViewHolder{

        private ImageView foto;
        private TextView likes;

        public FotoViewHolder(View itemView) {
            super(itemView);
            foto = (ImageView) itemView.findViewById(R.id.foto);
            likes = (TextView) itemView.findViewById(R.id.likes);
        }
    }
}
