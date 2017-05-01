package com.example.abrahamxsaboter.minialmacen;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class actualizar_datos3 extends AppCompatActivity {

    private TextView correo;
    private String datoCorreo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_datos3);
    }
    public void ActualizarDatosCuenta(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        Toast.makeText(getBaseContext(),"Contraseña actualizada con exito", Toast.LENGTH_LONG).show();
        finish();
    }

    public void CancelarActu(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        Toast.makeText(getBaseContext(),"Actualización Cancelada", Toast.LENGTH_LONG).show();
        finish();
    }

    //Bloquea el boton "Atras" del telefono
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            //Esto es lo que hace mi botón al pulsar ir a atrás (UN mensaje)
            Toast.makeText(getBaseContext(),"Por favor, actualice su contraseña", Toast.LENGTH_LONG).show();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
