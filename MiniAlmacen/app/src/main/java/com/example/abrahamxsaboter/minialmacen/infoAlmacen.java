package com.example.abrahamxsaboter.minialmacen;

/**
 * Created by Abraham on 26/04/2017.
 */

public class infoAlmacen {

    private String NombreAlmacen;
    private String NombreProducto;
    private String Descripcion;
    public infoAlmacen(String nombre, String producto, String descripcion) {
        NombreAlmacen = nombre;
        NombreProducto = producto;
        Descripcion = descripcion;
    }

    public String getNombreAlmacen() {
        return NombreAlmacen;
    }

    public void setNombreAlmacen(String nombreAlmacen) {
        NombreAlmacen = nombreAlmacen;
    }

    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        NombreProducto = nombreProducto;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }
}
