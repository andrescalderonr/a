package eci.edu.cvds.Parcial2.model;

import lombok.*;



public class Articulo {
    private String nombre;
    private int cantidad;
    private int precioTotal;

    public Articulo() {}

    // Constructor con parámetros
    public Articulo(String nombre, int cantidad, int precioTotal) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioTotal = precioTotal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(int precioTotal) {
        this.precioTotal = precioTotal;
    }


}
