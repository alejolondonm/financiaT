package com.financiat.upb;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Transaccion {

    private String nombre;
    private double valor;
    private String fecha;

    public Transaccion(String nombre, double valor, String fecha) {
        this.nombre = nombre;
        this.valor = valor;
        this.fecha = fecha;
    }
    public String getFecha() {
        return fecha;
    }

    public void setDia(String fecha) {
        this.fecha = fecha;
    }

    public double getValor() {
        return valor;
    }

    public String getValorFormateado() {
        DecimalFormat formatoSinDecimales = new DecimalFormat("#,###");
        return "$" + formatoSinDecimales.format(valor);
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
