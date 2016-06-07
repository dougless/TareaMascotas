package com.mascotas;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
public class ContactoActivity extends AppCompatActivity {

    Button boton, bEnviar;
    EditText nombre, correo, mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        bEnviar = (Button) findViewById(R.id.bEnviar);
        nombre = (EditText) findViewById(R.id.etNombre);
        correo = (EditText) findViewById(R.id.etCorreo);
        mensaje = (EditText) findViewById(R.id.etMensaje);

        Toolbar actionBar = (Toolbar) findViewById(R.id.actionBar);
        setSupportActionBar(actionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        boton = (Button) actionBar.findViewById(R.id.button);
        boton.setVisibility(View.INVISIBLE);


        bEnviar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                enviarCorreo();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void enviarCorreo(){
        String email = correo.getText().toString();
        String nom = nombre.getText().toString();

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_EMAIL, email);
        emailIntent.putExtra(Intent.EXTRA_REFERRER_NAME, nom);
        emailIntent.setType("message/rfc822");

        startActivity(Intent.createChooser(emailIntent, "Email "));
    }
}
