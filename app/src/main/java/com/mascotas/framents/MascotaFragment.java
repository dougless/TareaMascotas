package com.mascotas.framents;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mascotas.R;
import com.mascotas.adaptador.FotoAdaptador;
import com.mascotas.pojo.Foto;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MascotaFragment extends Fragment {

    ArrayList<Foto> fotos;
    RecyclerView listaFotos;

    public MascotaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_mascota, container, false);

        listaFotos = (RecyclerView) v.findViewById(R.id.rvgl);

        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);

        listaFotos.setLayoutManager(glm);

        inicializarLista();

        inicializarAdaptador();

        // Inflate the layout for this fragment
        return v;
    }

    public void inicializarAdaptador(){
        System.out.println("tamaño de la lista de fotos: " + fotos.size());
        FotoAdaptador fotoAdaptador = new FotoAdaptador(fotos,getActivity());
        listaFotos.setAdapter(fotoAdaptador);
    }

    public void inicializarLista(){

        fotos = new ArrayList<>();

        fotos.add(new Foto(4, R.drawable.chow1));
        fotos.add(new Foto(3, R.drawable.chow2));
        fotos.add(new Foto(6,R.drawable.chow3));
        fotos.add(new Foto(1, R.drawable.chow4));
        fotos.add(new Foto(12, R.drawable.chow5));
    }
}
