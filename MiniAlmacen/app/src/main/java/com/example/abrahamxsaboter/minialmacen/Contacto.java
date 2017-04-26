package com.example.abrahamxsaboter.minialmacen;

/**
 * Created by abrahamxsaboter on 23/04/2017.
 */

public class Contacto {
    private String Nombre, Telefono, Correo, Disenadora;

    public Contacto (String nombre, String telefono, String correo, String disenadora) {
        Nombre = nombre;
        Telefono = telefono;
        Correo = correo;
        Disenadora = disenadora;

    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getDisenadora() {
        return Disenadora;
    }

    public void setDisenadora(String disenadora) {
        Disenadora = disenadora;
    }
}
