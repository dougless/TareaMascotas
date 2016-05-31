package com.mascotas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button boton;
    ArrayList<Mascota> mascotas;
    ArrayList<Mascota> favoritas;
    RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar actionBar = (Toolbar) findViewById(R.id.actionBar);
        setSupportActionBar(actionBar);
        getSupportActionBar().setTitle("");

        boton = (Button) actionBar.findViewById(R.id.button);

        if(getIntent().getParcelableArrayListExtra("lista") != null)
            mascotas = getIntent().getParcelableArrayListExtra("lista");

        if(getIntent().getParcelableArrayListExtra("favoritas") != null)
            favoritas = getIntent().getParcelableArrayListExtra("favoritas");

        listaMascotas = (RecyclerView) findViewById(R.id.rv1);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);

        if(mascotas == null)
            inicializarLista();

        if(favoritas == null)
            favoritas = new ArrayList<>();

        inicializarAdaptador();

        boton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent activity2 = new Intent(MainActivity.this, Main2Activity.class);
                activity2.putExtra("lista", mascotas);
                activity2.putExtra("favoritas", favoritas);
                startActivity(activity2);
            }
        });


        System.out.println("---------------------------------favoritas: " + favoritas.size());
    }

    public void inicializarAdaptador(){
        MascotaAdaptador mascotaAdaptador = new MascotaAdaptador(mascotas,favoritas,this);
        listaMascotas.setAdapter(mascotaAdaptador);
    }

    public void inicializarLista(){

        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Doggy",0,R.drawable.chowchow));
        mascotas.add(new Mascota("Flooper",0,R.drawable.basset));
        mascotas.add(new Mascota("Rocky",0,R.drawable.husky));
        mascotas.add(new Mascota("Chester",0,R.drawable.labrador));
        mascotas.add(new Mascota("Bony",0,R.drawable.golden));
    }


}
