package com.example.abrahamxsaboter.minialmacen;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class EditarProducto extends AppCompatActivity {

    private static final int CAMERA_REQUEST_CODE = 1;
    private Activity activity;

    private TextView nom_producto;
    private TextView descripcion;
    //private TextView tipo;
    private TextView cantidad;

    private String datoNomProducto;
    private String datoDescripcion;
    //private String datoTipo;
    private String datoCantidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_producto);
        activity = this;

        Bundle bundle = getIntent().getExtras();

        datoNomProducto = bundle.getString("nom_producto");
        datoDescripcion = bundle.getString("descripcion");
        //datoTipo = bundle.getString("tipo");
        datoCantidad = bundle.getString("cantidad");


        nom_producto = (TextView) findViewById(R.id.nomProducto);
        descripcion = (TextView) findViewById(R.id.Descripcion);
        //tipo = (TextView) findViewById(R.id.Tipo);
        cantidad = (TextView) findViewById(R.id.Cantidad);

        nom_producto.setText(datoNomProducto);
        descripcion.setText(datoDescripcion);
        //tipo.setText(datoTipo);
        cantidad.setText(datoCantidad);

    }

    public void EditData(View v){
        Intent intent = new Intent(this, NuevoProducto.class);

        intent.putExtra("nom_producto",datoNomProducto);
        intent.putExtra("descripcion",datoDescripcion);
        //intent.putExtra("tipo",datoTipo);
        intent.putExtra("cantidad",datoCantidad);

        //Inicia la actividad
        startActivity(intent);
    }

    public void Cancelar(View v){
        Intent intent = new Intent(this, menu_usuario.class);
        Toast.makeText(getBaseContext(),"Registro De Productos Cancelado", Toast.LENGTH_LONG).show();
        //Inicia la actividad
        startActivity(intent);
    }

    public void  ActivaCamara(View view){

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.CAMERA)) {

            } else {
                ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.CAMERA}, CAMERA_REQUEST_CODE);
            }
            return;
        }
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //captura una imagen
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            //inicia la actividad (REQUEST_CODE: solicita los permisos)
            startActivityForResult(takePictureIntent, CAMERA_REQUEST_CODE);
        }
    }


    public boolean CheckPermission(String permission){
        int result = ContextCompat.checkSelfPermission(getApplicationContext(), permission);
        if(result == PackageManager.PERMISSION_GRANTED){
            return true;
        }

        return false;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode)
        {
            case CAMERA_REQUEST_CODE:
                if (CheckPermission(Manifest.permission.CAMERA)) {

               } else {

                }
                break;
        }
    }

    //Bloquea el boton "Atras" del telefono
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            //Esto es lo que hace mi botón al pulsar ir a atrás (UN mensaje)
            //Toast.makeText(getApplicationContext(), "Click en Editar",Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    /*
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Salir")
                    .setMessage("Estás seguro?")
                    .setNegativeButton(android.R.string.cancel, null)//sin listener
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {//un listener que al pulsar, cierre la aplicacion

                        @Override
                        public void onClick(DialogInterface dialog, int which){
                            //Salir
                            EditarProducto.this.finish();
                        }
                    })
                    .show();

            // Si el listener devuelve true, significa que el evento esta procesado, y nadie debe hacer nada mas
            return true;
        }
        //para las demas cosas, se reenvia el evento al listener habitual
        return super.onKeyDown(keyCode, event);
        }*/
}
