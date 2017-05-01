package com.example.abrahamxsaboter.minialmacen;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class NuevoProducto extends AppCompatActivity {

    private TextInputEditText nom_producto;
    private TextInputEditText descripcion;
    //private TextInputEditText tipo;
    private TextInputEditText cantidad;

    private String datoNomProducto;
    private String datoDescripcion;
    private String datoTipo;
    private String datoCantidad;
    private String cadena,a;

    Spinner combo;
    String[] contenido = {"Elige el tipo de Producto","Herramienta","Material Didactico","Consumibles","Staf","Papeleria"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_producto);

        //Aplica el botón atras en el ActionBar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        combo = (Spinner)findViewById(R.id.ComboTipoP);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,contenido);
        combo.setAdapter(adaptador);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            datoNomProducto = bundle.getString("nom_producto");
            datoDescripcion = bundle.getString("descripcion");
            datoCantidad = bundle.getString("cantidad");

            nom_producto = (TextInputEditText) findViewById(R.id.id_nom_producto);
            descripcion = (TextInputEditText) findViewById(R.id.id_descripcion);
            cantidad = (TextInputEditText) findViewById(R.id.id_cantidad);

            nom_producto.setText(datoNomProducto);
            descripcion.setText(datoDescripcion);
            cantidad.setText(datoCantidad);
        }
    }

    public void EnvioDatos(View v) {
        nom_producto = (TextInputEditText) findViewById(R.id.id_nom_producto);
        descripcion = (TextInputEditText) findViewById(R.id.id_descripcion);
        combo = (Spinner)findViewById(R.id.ComboTipoP);
        cantidad = (TextInputEditText) findViewById(R.id.id_cantidad);

        Intent intent = new Intent(this, EditarProducto.class);

        cadena = String.valueOf(contenido);

        intent.putExtra("nom_producto", nom_producto.getText().toString());
        intent.putExtra("descripcion", descripcion.getText().toString());
        //intent.putExtra(String.valueOf(contenido), combo.getSelectedItem().toString());
        intent.putExtra(String.valueOf(cadena = "tipo"), combo.getSelectedItem().toString());
        intent.putExtra("cantidad", cantidad.getText().toString());

        startActivity(intent);
        finish();

    }

    public void Cancelar(View v) {
        Intent intent = new Intent(this, menu_usuario.class);
        Toast.makeText(getBaseContext(), "Registro De Productos Cancelado", Toast.LENGTH_LONG).show();
        //Inicia la actividad
        startActivity(intent);
        finish();
    }

}

