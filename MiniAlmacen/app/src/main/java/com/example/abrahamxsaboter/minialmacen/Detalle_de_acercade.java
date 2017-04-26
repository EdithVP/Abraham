package com.example.abrahamxsaboter.minialmacen;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Detalle_de_acercade extends AppCompatActivity {

    private static final int CALL_REQUEST_CODE = 1;
    private Activity activity;

    //variables globales
    TextView tvNombre;
    TextView tvTelefono;
    TextView tvCorreo;
    TextView tvCargo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_de_acercade);

        //Aplica el botón atras en el ActionBar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        activity = this;

        // Bundle : obtencion de parametros
        Bundle parametros = getIntent().getExtras();

        //Establecer los parametros
        String nombre = parametros.getString("nombre");
        String telefono = parametros.getString("telefono");
        String correo = parametros.getString("correo");
        String cargo = parametros.getString("cargo");

        //Inicializar los TextView
        tvNombre = (TextView) findViewById(R.id.textVistaNombre);
        tvTelefono = (TextView) findViewById(R.id.textVistaTelefono);
        tvCorreo = (TextView) findViewById(R.id.textVistaCorreo);
        tvCargo = (TextView) findViewById(R.id.textVistaCargo);


        //llama a los TextView
        tvNombre.setText(nombre);
        tvTelefono.setText(telefono);
        tvCorreo.setText(correo);
        tvCargo.setText(cargo);
    }

    public void Llamar(View v) {
        String telefono = tvTelefono.getText().toString();
        //Revisa si se tienen los permisos de llamar (se tienen que solicitar los permisos)
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            //Solicita el permiso de llamar
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.CALL_PHONE}, CALL_REQUEST_CODE);
            return;
        }
        //Inicia la actividad
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel: " + telefono)));
    }

    public void Llamar_a_correo(View v){
        String correo = tvCorreo.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("correo:"));
        //
        intent.putExtra(Intent.EXTRA_EMAIL,correo);
        //Manda a llamar a tipo de aplicacion
        intent.setType("message/rfc822");

        //Te da a elegir la aplicacion a elegir
        startActivity(Intent.createChooser(intent,"Enviar a correo"));
    }

    //Bloquea el boton "Atras" del telefono
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            // Esto es lo que hace mi botón al pulsar ir a atrás (UN mensaje)
            //Toast.makeText(getApplicationContext(), "",Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            //Permiso de llamada
            case CALL_REQUEST_CODE:
                break;
        }
    }
    //Bloquea el boton "Atras" del telefono
}
