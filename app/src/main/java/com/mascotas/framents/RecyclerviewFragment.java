package com.mascotas.framents;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mascotas.Main2Activity;
import com.mascotas.MainActivity;
import com.mascotas.R;
import com.mascotas.adaptador.MascotaAdaptador;
import com.mascotas.pojo.Mascota;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by DESARROLLO2 on 7/06/2016.
 */
public class RecyclerviewFragment extends Fragment{

    Button boton;
    ArrayList<Mascota> mascotas;
    ArrayList<Mascota> favoritas;
    RecyclerView listaMascotas;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        //return super.onCreateView(layoutInflater,container,savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview,container,false);

        Toolbar actionBar = (Toolbar) getActivity().findViewById(R.id.actionBar);
        boton = (Button) actionBar.findViewById(R.id.button);

        if(getActivity().getIntent().getParcelableArrayListExtra("lista") != null)
            mascotas = getActivity().getIntent().getParcelableArrayListExtra("lista");

        if(getActivity().getIntent().getParcelableArrayListExtra("favoritas") != null)
            favoritas = getActivity().getIntent().getParcelableArrayListExtra("favoritas");

        listaMascotas = (RecyclerView) v.findViewById(R.id.rv1);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);

        if(mascotas == null)
            inicializarLista();

        if(favoritas == null)
            favoritas = new ArrayList<>();

        inicializarAdaptador();

        boton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent activity2 = new Intent(getActivity(), Main2Activity.class);
                activity2.putExtra("lista", mascotas);
                activity2.putExtra("favoritas", favoritas);
                startActivity(activity2);
            }
        });

        return v;
    }

    public void inicializarAdaptador(){
        MascotaAdaptador mascotaAdaptador = new MascotaAdaptador(mascotas,favoritas,getActivity());
        listaMascotas.setAdapter(mascotaAdaptador);
    }

    public void inicializarLista(){

        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Doggy", 0, R.drawable.chowchow));
        mascotas.add(new Mascota("Flooper", 0, R.drawable.basset));
        mascotas.add(new Mascota("Rocky",0,R.drawable.husky));
        mascotas.add(new Mascota("Chester", 0, R.drawable.labrador));
        mascotas.add(new Mascota("Bony", 0, R.drawable.golden));
    }

}
