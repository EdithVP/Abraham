package com.example.abrahamxsaboter.minialmacen;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

public class producto extends AppCompatActivity {

    private TextInputEditText nom_producto;
    private TextInputEditText descripcion;
    private TextInputEditText tipo;
    private TextInputEditText cantidad;

    private String datoNomProducto;
    private String datoDescripcion;
    private String datoTipo;
    private String datoCantidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);

        //Aplica el botón atras en el ActionBar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Bundle bundle = getIntent().getExtras();

        if(bundle != null) {
            datoNomProducto = bundle.getString("nom_producto");
            datoDescripcion = bundle.getString("descripcion");
            datoTipo = bundle.getString("tipo");
            datoCantidad = bundle.getString("cantidad");

            nom_producto = (TextInputEditText) findViewById(R.id.id_nom_producto);
            descripcion = (TextInputEditText) findViewById(R.id.id_descripcion);
            tipo = (TextInputEditText) findViewById(R.id.id_tipo);
            cantidad = (TextInputEditText) findViewById(R.id.id_cantidad);

            nom_producto.setText(datoNomProducto);
            descripcion.setText(datoDescripcion);
            tipo.setText(datoTipo);
            cantidad.setText(datoCantidad);

        }
     }

    public void EnvioDatos(View v) {
        nom_producto = (TextInputEditText) findViewById(R.id.id_nom_producto);
        descripcion = (TextInputEditText) findViewById(R.id.id_descripcion);
        tipo = (TextInputEditText) findViewById(R.id.id_tipo);
        cantidad = (TextInputEditText) findViewById(R.id.id_cantidad);

        Intent intent = new Intent(this, EditarProducto.class);

        intent.putExtra("nom_producto",nom_producto.getText().toString());
        intent.putExtra("descripcion",descripcion.getText().toString());
        intent.putExtra("tipo",tipo.getText().toString());
        intent.putExtra("cantidad",cantidad.getText().toString());

        startActivity(intent);

    }

    public void Cancelar(View v){
        Intent intent = new Intent(this, menu_usuario.class);
        Toast.makeText(getBaseContext(),"Registro De Productos Cancelado", Toast.LENGTH_LONG).show();
        //Inicia la actividad
        startActivity(intent);
    }

}
