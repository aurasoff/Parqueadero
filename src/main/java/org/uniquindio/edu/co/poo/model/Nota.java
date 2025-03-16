package org.uniquindio.edu.co.poo.model;

public class Nota {

    private String nombre;
    public float valor;

    public Nota(String nombre, float valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Nota{" +
                "nombre='" + nombre + '\'' +
                ", valor=" + valor +
                '}';
    }

    public String actualizarNota(float nuevoValorNota) {
        setValor(nuevoValorNota);
        return "Nora actualizada";
    }
}