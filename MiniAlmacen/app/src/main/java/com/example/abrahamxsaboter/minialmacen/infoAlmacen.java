package com.example.abrahamxsaboter.minialmacen;

public class infoAlmacen {

    private String NombreAlmacen;
    private String NombreProducto;
    private String Descripcion;
    private String Cantidad;
    public infoAlmacen(String nombre, String descripcion, String producto, String cantidad) {
        NombreAlmacen = nombre;
        NombreProducto = producto;
        Descripcion = descripcion;
        Cantidad = cantidad;
    }

    public String getCantidad() {
        return Cantidad;
    }

    public void setCantidad(String cantidad) {
        Cantidad = cantidad;
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
