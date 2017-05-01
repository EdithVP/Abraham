package com.example.abrahamxsaboter.minialmacen;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class actualizar_datos2 extends AppCompatActivity {

    private TextView correo;
    private String datoCorreo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_datos2);

        Bundle bundle = getIntent().getExtras();

        datoCorreo = bundle.getString("correo");
        correo = (TextView) findViewById(R.id.correoEnviado);
        correo.setText(datoCorreo);


    }

    public void ActualizarDatosCuenta(View v) {
        Intent intent = new Intent(this, actualizar_datos3.class);
        startActivity(intent);
        Toast.makeText(getBaseContext(),"Verificando código de seguridad...", Toast.LENGTH_LONG).show();
        finish();
    }

    public void CancelarActu(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        Toast.makeText(getBaseContext(),"Actualización Cancelada", Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == event.KEYCODE_BACK) {
            Intent intent = new Intent(this, ActualizarDatos.class);
            intent.putExtra("correo",datoCorreo);
            //Inicia la actividad
            startActivity(intent);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
