package com.financiat.upb;

public class Transaccion {

    private String nombre;
    private double valor;
private int dia;



    public Transaccion(String nombre, double valor, int dia) {
        this.nombre = nombre;
        this.valor = valor;
        this.dia = dia;
    }
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
