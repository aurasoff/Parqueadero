package org.uniquindio.edu.co.poo.model;
import org.uniquindio.edu.co.poo.model.Nota;

import javax.swing.*;

public class Estudiante {
    private String nombre;
    private String identificacion;
    private Nota[] listaNotas = new Nota[5];

    public Estudiante(String nombre, String identificacion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void registrarNota(String nombreNota, float valorNota) {
        for (int i = 0; i < listaNotas.length; i++) {
            if (listaNotas[i] == null) {
                listaNotas[i] = new Nota(nombreNota, valorNota);
                return;
            }
        }
    }

    public void actualizarNota(int indice, float nuevoValor) {
        if (indice >= 0 && indice < listaNotas.length && listaNotas[indice] != null) {
            listaNotas[indice].setValor(nuevoValor);
        }
    }

    public float calcularPromedio() {
        float suma = 0;
        int count = 0;
        for (Nota nota : listaNotas) {
            if (nota != null) {
                suma += nota.getValor();
                count++;
            }
        }
        return count > 0 ? suma / count : 0;
    }

    public boolean puedeAprobar() {
        return calcularPromedio() >= 3.0;
    }

    public float calcularNotaNecesaria() {
        float suma = 0;
        int count = 0;
        for (Nota nota : listaNotas) {
            if (nota != null) {
                suma += nota.getValor();
                count++;
            }
        }
        if (count < 5) return 3.0f;
        float necesaria = (3.0f * count) - suma;
        return necesaria <= 5 ? necesaria : -1;
    }

    public Nota[] getListaNotas() {
        return listaNotas;
    }
}