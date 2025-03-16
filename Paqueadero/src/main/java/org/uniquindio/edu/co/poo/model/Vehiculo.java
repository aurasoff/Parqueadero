package org.uniquindio.edu.co.poo.model;

public class Vehiculo {
    private String placa;
    private String marca;

    public Vehiculo(String placa, String marca) {
        this.placa = placa;
        this.marca = marca;
    }
    public String getPlaca() {return placa;}
    public String getMarca() {return marca;}
    public void setPlaca(String placa) {this.placa = placa;}
    public void setMarca(String marca) {this.marca = marca;}

    @Override
    public String toString() {
        return "Vehiculo{" +
                "marca='" + marca + '\'' +
                ", placa='" + placa + '\'' +
                '}';
    }


}