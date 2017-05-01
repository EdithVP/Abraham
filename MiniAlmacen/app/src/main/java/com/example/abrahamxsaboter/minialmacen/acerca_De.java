package com.example.abrahamxsaboter.minialmacen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by abrahamxsaboter on 23/04/2017.
 */

public class acerca_De extends AppCompatActivity {

    ArrayList<Contacto> contactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);

        //Aplica el botón atras en el ActionBar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        contactos = new ArrayList();
        contactos.add(new Contacto("Mares Sánchez Abraham","5561178458","abrahamyeahmares@gmail.com","Programador de Base de Datos y Servidor"));
        contactos.add(new Contacto("Ortiz Hernandez Mari Carmen","5554683529","marycarmenortiz19@gmail.com","Diseñadora de la aplicación"));
        contactos.add(new Contacto("Valentin Perez Edith","5547900160","edithvp0406@gmail.com","Diseñadora de la aplicación"));
        contactos.add(new Contacto("Vazquez Marcelo Alberto Abraham","5575397412","abrahamgears5555@gmail.com.com","Programador de la aplicación"));

        ArrayList<String> nombres = new ArrayList<String>();

        for (Contacto contacto:contactos ) {
            nombres.add(contacto.getNombre());

        }

        ListView listViewContactos = (ListView) findViewById(R.id.listViewContactos);
        listViewContactos.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1,nombres));
        //Eventos cada ves que se da click
        //listViewContactos.setOnItemClickListener(parent,view,position,id);
        listViewContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Intent = Implicito: llamada a otra aplicacion (actividad)
                Intent contact = new Intent(acerca_De.this,Detalle_de_acercade.class);

                contact.putExtra("nombre",contactos.get(position).getNombre());
                contact.putExtra("telefono",contactos.get(position).getTelefono());
                contact.putExtra("correo",contactos.get(position).getCorreo());
                contact.putExtra("cargo",contactos.get(position).getDisenadora());

                //atrapar los parametros


                //Inicia la actividad
                startActivity(contact);
            }
        });
    }

}

