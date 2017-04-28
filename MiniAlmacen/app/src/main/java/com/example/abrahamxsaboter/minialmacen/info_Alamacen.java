package com.example.abrahamxsaboter.minialmacen;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class info_Alamacen extends AppCompatActivity {
    TextView nombre,desc,pro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info__alamacen);

        //Aplica el botón atras en el ActionBar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        nombre = (TextView)findViewById(R.id.textoTitulo);
        desc = (TextView)findViewById(R.id.DescripcionAl);
        pro = (TextView)findViewById(R.id.TextoProducto);
        Bundle parametros = getIntent().getExtras();
        String nombre1 = parametros.getString("Nombre");
        String descrip = parametros.getString("desc");
        String produ = parametros.getString("pro");

        nombre.setText(nombre1);
        desc.setText(descrip);
        pro.setText(produ);

    }
}
