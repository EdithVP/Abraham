package com.example.abrahamxsaboter.minialmacen;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class menu_usuario extends AppCompatActivity {

    private static final int CALL_REQUEST_CODE = 1;
    private static final int CAMERA_REQUEST_CODE = 2;
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_usuario);
        activity = this;
    }


    //Linkeos
    public void AlmacenNuevo(View v) {
        Intent intent = new Intent(this, NuevoProducto.class);
        startActivity(intent);
    }

    public void AbrirRealizarConculta(View v) {
        Intent intent = new Intent(this, Consultas.class);
        startActivity(intent);
    }

    public void AbrirYouTube(View v) {
        Uri uri = Uri.parse("https://www.youtube.com/channel/UCm_W9Ffk4EkCCEoncfIGHhw");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void AbrirSoporte(View v) {

        //Revisa si se tienen los permisos de llamar (se tienen que solicitar los permisos)
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            //Solicita el permiso de llamar
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.CALL_PHONE}, CALL_REQUEST_CODE);
            return;
        }
        //Inicia la actividad
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:5575397412")));
    }
    public void AbrirAcercaDe(View v) {
        Intent intent = new Intent(this, acerca_De.class);
        startActivity(intent);
    }

    public boolean CheckPermission(String permission) {
        int result = ContextCompat.checkSelfPermission(getApplicationContext(), permission);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        }

        return false;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case CAMERA_REQUEST_CODE:
                if (CheckPermission(Manifest.permission.CAMERA)) {

                } else {

                }
                break;
            //Permiso de camara
            case CALL_REQUEST_CODE:
                break;
        }
    }

    public void CerrarSesion(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        Toast.makeText(getBaseContext(),"Sesión Cerrada", Toast.LENGTH_LONG).show();
    }

    //Bloquea el boton "Atras" del telefono
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            // Esto es lo que hace mi botón al pulsar ir a atrás
            Toast.makeText(getApplicationContext(), "Por favor cierre su sesión si desea salir",
                    Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}