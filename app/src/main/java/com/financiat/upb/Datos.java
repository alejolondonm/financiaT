package com.financiat.upb;

import android.app.Application;

import java.util.ArrayList;

public class Datos extends Application {
    private ArrayList<Transaccion> listaIngresos = new ArrayList<>();

    private double ingresos = 0;
    private double gastos = 0;

    public ArrayList<Transaccion> getListaIngresos() {
        return listaIngresos;
    }
    public void addIngreso(Transaccion ingreso){
        ingresos += ingreso.getValor();
        listaIngresos.add(ingreso);
    }
    public double getGastos() {
        return gastos;
    }

    public void setGastos(double gastos) {
        this.gastos = gastos;
    }

    public double getIngresos() {
        return ingresos;
    }

    public void setIngresos(double ingresos) {
        this.ingresos = ingresos;
    }
}
