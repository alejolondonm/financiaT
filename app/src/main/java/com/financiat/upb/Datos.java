package com.financiat.upb;

import android.app.Application;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Datos extends Application {
    private ArrayList<Transaccion> listaIngresos = new ArrayList<>();
    private ArrayList<Transaccion> listaGastos = new ArrayList<>();

    private double ingresos = 0;
    private double gastos = 0;

    public ArrayList<Transaccion> getListaIngresos() {
        return listaIngresos;
    }

    public ArrayList<Transaccion> getListaGastos() {
        return listaGastos;
    }
    public void addIngreso(Transaccion ingreso){
        ingresos += ingreso.getValor();
        listaIngresos.add(ingreso);
    }

    public void addGasto(Transaccion gasto){
        gastos += gasto.getValor();
        listaGastos.add(gasto);
    }
    public String getGastos() {
        DecimalFormat formatoSinDecimales = new DecimalFormat("#,###");
        return "$" + formatoSinDecimales.format(gastos);
    }

    public void setGastos(double gastos) {
        this.gastos = gastos;
    }

    public String getIngresos() {
        DecimalFormat formatoSinDecimales = new DecimalFormat("#,###");
        return "$" + formatoSinDecimales.format(ingresos);
    }

    public void setIngresos(double ingresos) {
        this.ingresos = ingresos;
    }
}
