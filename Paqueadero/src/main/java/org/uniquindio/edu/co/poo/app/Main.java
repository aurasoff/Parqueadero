package org.uniquindio.edu.co.poo.app;

import org.uniquindio.edu.co.poo.model.Parqueadero;
import org.uniquindio.edu.co.poo.model.Vehiculo;

import javax.swing.*;

public class Main {
        public static void main(String[] args) {
            Parqueadero parqueadero = new Parqueadero("Parqueadero La Aurora", "Calle 123, Ciudad");
            parqueadero.agregarVehiculo(new Vehiculo("XYZ-123", "Toyota"));
            parqueadero.agregarVehiculo(new Vehiculo("ABC-789", "Honda"));
            parqueadero.agregarVehiculo(new Vehiculo("MNO-456", "Ford"));
            parqueadero.agregarVehiculo(new Vehiculo("DEF-345", "Chevrolet"));

            int opcion;
            do {
                String menu = "1. Agregar vehículo\n2. Mostrar vehículos\n3. Ordenar vehículos por placa\n4. Salir";
                opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));

                switch (opcion) {
                    case 1:
                        String placa = JOptionPane.showInputDialog("Ingrese la placa del vehículo:");
                        String marca = JOptionPane.showInputDialog("Ingrese la marca del vehículo:");
                        String mensaje = parqueadero.agregarVehiculo(placa, marca);
                        JOptionPane.showMessageDialog(null, mensaje);
                        break;
                    case 2:
                        StringBuilder lista = new StringBuilder("Vehículos en el parqueadero:\n");
                        for (Vehiculo v : parqueadero.getVehiculos()) {
                            lista.append(v).append("\n");
                        }
                        JOptionPane.showMessageDialog(null, lista.toString());
                        break;
                    case 3:
                        parqueadero.ordenarPorPlaca();
                        JOptionPane.showMessageDialog(null, "Los vehículos han sido ordenados por placa.");
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null, "Saliendo.");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida. Intente de nuevo.");
                }
            } while (opcion != 4);
        }
}


