package com.example.abrahamxsaboter.minialmacen;


import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Consultas extends AppCompatActivity {
    String[] almacen = new String[]{};
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultas);
        activity = this;

        //Aplica el botón atras en el ActionBar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    public void boton1(View v){
        Intent evento = new Intent(this,info_Alamacen.class);
        almacen = new String[]{"ALMACEN DE PROYECTORES", "Almacén dedicado a contener\\nproyectores para uso\\nacadémico y con motivos\\neducativos.", "PROYECTORES"};
        String nombre = almacen[0];
        String descrip = almacen[1];
        String pro = almacen[2];
        evento.putExtra("nombre",nombre);
        evento.putExtra("desc",descrip);
        evento.putExtra("pro",pro);
        startActivity(evento);
    }
    public void boton2(View v){
        Intent evento;
        evento = new Intent(this,info_Alamacen.class);
        almacen = new String[]{"ALMACEN DE TELEVISIONES", "Almacén dedicado a contener\\ntelevisores para uso\\nacadémico y con motivos\\neducativos o entretenimiento.", "TELEVISORES"};
        String nombre = almacen[0];
        String descrip = almacen[1];
        String pro = almacen[2];
        evento.putExtra("nombre",nombre);
        evento.putExtra("desc",descrip);
        evento.putExtra("pro",pro);
        startActivity(evento);
    }
    public void boton3(View v){
        Intent evento;
        evento = new Intent(this,info_Alamacen.class);
        almacen = new String[]{"ALMACEN DE HERRAMIENTAS", "Almacén dedicado a contener\\nherramientas para uso\\nprofecional y con motivos\\ntecnicos y auxiliares.", "HERRAMIENTAS"};
        String nombre = almacen[0];
        String descrip = almacen[1];
        String pro = almacen[2];
        evento.putExtra("nombre",nombre);
        evento.putExtra("desc",descrip);
        evento.putExtra("pro",pro);
        startActivity(evento);
    }
    public void boton4(View v){
        Intent evento;
        evento = new Intent(this,info_Alamacen.class);
        almacen = new String[]{"ALMACEN DE CABLES DE VISION", "Almacén dedicado a contener\\ncables de visión para uso\\nacademico y con motivos\\neducativos y entretenimiento.", "CABLES DE VIDEO"};
        String nombre = almacen[0];
        String descrip = almacen[1];
        String pro = almacen[2];
        evento.putExtra("nombre",nombre);
        evento.putExtra("desc",descrip);
        evento.putExtra("pro",pro);
        startActivity(evento);
    }
    public void boton5(View v){
        Intent evento;
        evento = new Intent(this,info_Alamacen.class);
        almacen = new String[]{"ALMACEN DE TORNOS\\nY\\nFREZADORAS", "Almacén dedicado a contener\\ntornos y frezadoras para uso\\nacademico y con motivos\\neducativos y profecionales.", "TORNOS Y FREZADORAS"};
        String nombre = almacen[0];
        String descrip = almacen[1];
        String pro = almacen[2];
        evento.putExtra("nombre",nombre);
        evento.putExtra("desc",descrip);
        evento.putExtra("pro",pro);
        startActivity(evento);
    }
}
