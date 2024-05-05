package com.financiat.upb;

import android.app.Application;

public class Datos extends Application {
    String ingresos = "$10.000";
    String gastos = "$20.000";

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
