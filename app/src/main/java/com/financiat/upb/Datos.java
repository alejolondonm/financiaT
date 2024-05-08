package com.financiat.upb;

import android.app.Application;

import java.util.ArrayList;

public class Datos extends Application {
    private ArrayList<Transaccion> listaIngresos = new ArrayList<>();

    private String ingresos = "$10.000";
    private String gastos = "$20.000";

    public ArrayList<Transaccion> getListaIngresos() {
        return listaIngresos;
    }
    public void addIngreso(Transaccion ingreso){
        listaIngresos.add(ingreso);
    }
    public String getGastos() {
        return gastos;
    }

    public void setGastos(String gastos) {
        this.gastos = gastos;
    }

    public String getIngresos() {
        return ingresos;
    }

    public void setIngresos(String ingresos) {
        this.ingresos = ingresos;
    }
}
