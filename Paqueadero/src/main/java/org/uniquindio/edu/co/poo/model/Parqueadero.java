package org.uniquindio.edu.co.poo.model;

import java.util.ArrayList;
import java.util.List;

public class Parqueadero {
        private String nombre;
        private String ubicacion;
        private List<Vehiculo> listaVehiculos;

        public Parqueadero(String nombre, String ubicacion) {
            this.nombre = nombre;
            this.ubicacion = ubicacion;
            this.listaVehiculos = new ArrayList<>();
        }

        public void agregarVehiculo(Vehiculo vehiculo) {
            listaVehiculos.add(vehiculo);
        }

        public List<Vehiculo> getVehiculos() {
            return listaVehiculos;
        }

        public String agregarVehiculo(String placa, String marca) {
            Vehiculo encontrado = buscarVehiculo(placa);
            if (encontrado != null) {
                return "El vehiculo " + encontrado.getPlaca() + " ya está en el parqueadero";
            }
            Vehiculo nuevoVehiculo = new Vehiculo(placa, marca);
            listaVehiculos.add(nuevoVehiculo);
            return "El vehículo fue registrado exitosamente";
        }

        private Vehiculo buscarVehiculo(String placa) {
            for (Vehiculo vehiculo : listaVehiculos) {
                if (vehiculo.getPlaca().equals(placa)) {
                    return vehiculo;
                }
            }
            return null;
        }

        public void ordenarPorPlaca() {
            int v = listaVehiculos.size();
            boolean intercambiado;

            for (int i = 0; i < v - 1; i++) {
                    intercambiado = false;
                for (int j = 0; j < v - 1 - i; j++) {
                    if (listaVehiculos.get(j).getPlaca().compareTo(listaVehiculos.get(j + 1).getPlaca()) > 0) {
                        Vehiculo vehiculoAux = listaVehiculos.get(j);
                        listaVehiculos.set(j, listaVehiculos.get(j + 1));
                        listaVehiculos.set(j + 1, vehiculoAux);
                        intercambiado = true;
                    }
                }
                if (!intercambiado) break;
            }
        }

}