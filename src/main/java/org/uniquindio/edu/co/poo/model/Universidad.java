package org.uniquindio.edu.co.poo.model;
import java.util.ArrayList;
import org.uniquindio.edu.co.poo.model.Estudiante;

import javax.swing.JOptionPane;

public class Universidad {
    private String nombre;
    private String ubicacion;
    public ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();

    public Universidad(String nombre,String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    public void registrarEstudiante() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del estudiante");
        String identificacion = JOptionPane.showInputDialog("Ingrese la identificación del estudiante");
        Estudiante estudiante = new Estudiante(nombre, identificacion);
        listaEstudiantes.add(estudiante);
        for (int i = 0; i < 5; i++) {
            String nombreNota = JOptionPane.showInputDialog("Ingrese el nombre de la nota " + (i + 1));
            float valorNota;
            while (true) {
                try {
                    valorNota = Float.parseFloat(JOptionPane.showInputDialog("Ingrese la calificación para " + nombreNota));
                    if (valorNota < 0 || valorNota > 5) {
                        JOptionPane.showMessageDialog(null, "Error: La calificación debe estar entre 0 y 5.");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Error: Ingrese un número válido.");
                }
            }
            estudiante.registrarNota(nombreNota, valorNota);
        }
    }

    public void mostrarEstudiantes() {
        StringBuilder sb = new StringBuilder("Lista de estudiantes:\n");
        for (Estudiante estudiante : listaEstudiantes) {
            sb.append(estudiante.getNombre()).append(" - ID: ").append(estudiante.getIdentificacion())
                    .append(" - Promedio: ").append(estudiante.calcularPromedio()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    public void prediccionAprobacion() {
        StringBuilder sb = new StringBuilder("Estudiantes con posibilidad de aprobar:\n");
        for (Estudiante estudiante : listaEstudiantes) {
            if (estudiante.calcularPromedio() < 3.0) {
                float necesaria = estudiante.calcularNotaNecesaria();
                if (necesaria != -1) {
                    sb.append(estudiante.getNombre()).append(" necesita mejorar una nota a: ")
                            .append(necesaria).append("\n");
                }
            }
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
    public void mejorNotaPorPosicion(int posicion) {
        Estudiante mejorEstudiante = null;
        float mejorNota = -1;

        for (Estudiante estudiante : listaEstudiantes) {
            if (posicion >= 0 && posicion < 5 && estudiante.getListaNotas()[posicion] != null) {
                float nota = estudiante.getListaNotas()[posicion].getValor();
                if (nota > mejorNota) {
                    mejorNota = nota;
                    mejorEstudiante = estudiante;
                }
            }
        }
        if (mejorEstudiante != null) {
            JOptionPane.showMessageDialog(null, "El mejor estudiante en la nota " + (posicion + 1) + " es " +
                    mejorEstudiante.getNombre() + " con una calificación de " + mejorNota);
        } else {
            JOptionPane.showMessageDialog(null, "No hay notas registradas en la posición indicada.");
        }
    }
    public void mejorPromedio() {
        Estudiante mejorEstudiante = null;
        float mejorPromedio = -1;

        for (Estudiante estudiante : listaEstudiantes) {
            float promedio = estudiante.calcularPromedio();
            if (promedio > mejorPromedio) {
                mejorPromedio = promedio;
                mejorEstudiante = estudiante;
            }
        }
        if (mejorEstudiante != null) {
            JOptionPane.showMessageDialog(null, "El estudiante con mejor promedio es " + mejorEstudiante.getNombre() + " con un promedio de " + mejorPromedio);
        } else {
            JOptionPane.showMessageDialog(null, "No hay estudiantes registrados.");
        }
    }
    public void actualizarNota() {
        String id = JOptionPane.showInputDialog("Ingrese la identificación del estudiante");
        for (Estudiante estudiante : listaEstudiantes) {
            if (estudiante.getIdentificacion().equals(id)) {
                int indice = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de la nota a actualizar (1-5):")) - 1;
                float nuevoValor = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el nuevo valor de la nota:"));
                estudiante.actualizarNota(indice, nuevoValor);
                JOptionPane.showMessageDialog(null, "Nota actualizada correctamente.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Estudiante no encontrado.");
    }

}

