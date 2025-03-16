package org.uniquindio.edu.co.poo.app;

import org.uniquindio.edu.co.poo.model.Universidad;

import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        Universidad universidad = new Universidad("Uniquindío", "Calle 13 #12");

        boolean continuar = true;
        while (continuar) {
            String opcion = JOptionPane.showInputDialog(
                    "Seleccione una opción:\n" +
                            "1. Registrar Estudiante\n" +
                            "2. Mostrar Estudiantes\n" +
                            "3. Actualizar Nota\n" +
                            "4. Predicción de Aprobación\n" +
                            "5. Mejor Nota por Posición\n" +
                            "6. Mejor Promedio\n" +
                            "7. Salir");
            switch (opcion) {
                case "1":
                    universidad.registrarEstudiante();
                    break;
                case "2":
                    universidad.mostrarEstudiantes();
                    break;
                case "3":
                    universidad.actualizarNota();
                    break;
                case "4":
                    universidad.prediccionAprobacion();
                    break;
                case "5":
                    int posicion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posición de la nota (1-5):")) - 1;
                    universidad.mejorNotaPorPosicion(posicion);
                    break;
                case "6":
                    universidad.mejorPromedio();
                    break;
                case "7":
                    continuar = false;
                    JOptionPane.showMessageDialog(null, "Gracias por usar el sistema de gestión de estudiantes.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida, intente de nuevo.");
                    break;
            }
        }
    }
}
