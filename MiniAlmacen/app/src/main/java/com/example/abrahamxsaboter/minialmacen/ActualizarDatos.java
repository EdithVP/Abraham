package com.example.abrahamxsaboter.minialmacen;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

public class ActualizarDatos extends AppCompatActivity {

    private TextInputEditText correo;

    private String datoCorreo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_datos);
        //Aplica el botón atras en el ActionBar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        //Enviamos los datos a traves de un TextEdit
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            datoCorreo = bundle.getString("correo");
            correo = (TextInputEditText) findViewById(R.id.id_app_correo);
            correo.setText(datoCorreo);
        }

    }
    public void ActualizarDatosCuenta(View v) {

        //Buscamos la id del TextEdit
        correo = (TextInputEditText) findViewById(R.id.id_app_correo);
        Intent intent = new Intent(this, actualizar_datos2.class);
        //Obtemos los datos
        intent.putExtra("correo", correo.getText().toString());
        Toast.makeText(getBaseContext(),"Enviando código de seguridad al su correo...", Toast.LENGTH_LONG).show();
        startActivity(intent);
        finish();
    }

    public void CancelarActu(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        Toast.makeText(getBaseContext(),"Actualización Cancelada", Toast.LENGTH_LONG).show();
        finish();
    }

    /*//Bloquea el boton "Atras" del telefono
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            //Esto es lo que hace mi botón al pulsar ir a atrás (UN mensaje)
            //Toast.makeText(getApplicationContext(), "Click en Salir", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }*/
}
