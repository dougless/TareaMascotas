package com.mascotas;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    RecyclerView listaMascotas;
    ArrayList<Mascota> mascotas;
    ArrayList<Mascota> favoritas;
    Button boton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Toolbar actionBar = (Toolbar) findViewById(R.id.actionBar);
        setSupportActionBar(actionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        boton = (Button) actionBar.findViewById(R.id.button);
        boton.setVisibility(View.INVISIBLE);


        listaMascotas = (RecyclerView) findViewById(R.id.rv1);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        llm.setReverseLayout(true);
        llm.setStackFromEnd(true);

        listaMascotas.setLayoutManager(llm);
        mascotas =  getIntent().getParcelableArrayListExtra("lista");
        favoritas =  getIntent().getParcelableArrayListExtra("favoritas");

        if(favoritas != null)
            inicializarAdaptador();
    }


    public void inicializarAdaptador(){
        MascotaAdaptador mascotaAdaptador = new MascotaAdaptador(favoritas,favoritas,this);
        listaMascotas.setAdapter(mascotaAdaptador);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent activity = new Intent(Main2Activity.this, MainActivity.class);
                activity.putExtra("lista", mascotas);
                activity.putExtra("favoritas", favoritas);
                startActivity(activity);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
