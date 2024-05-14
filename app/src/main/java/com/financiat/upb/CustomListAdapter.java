package com.financiat.upb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class CustomListAdapter extends ArrayAdapter<Transaccion> {
    private ArrayList<Transaccion> lista;

    Map<String, String> mesesMapa = new HashMap<String, String>() {{
        put("01", "Enero");
        put("02", "Febrero");
        put("03", "Marzo");
        put("04", "Abril");
        put("05", "Mayo");
        put("06", "Junio");
        put("07", "Julio");
        put("08", "Agosto");
        put("09", "Septiembre");
        put("10", "Octubre");
        put("11", "Noviembre");
        put("12", "Diciembre");
    }};
    public CustomListAdapter(Context context, int resource, int textViewResourceId, ArrayList<Transaccion> objects) {
        super(context, resource, textViewResourceId, objects);
        lista = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View row = inflater.inflate(R.layout.list_item, parent, false);

        TextView texto_nombre = row.findViewById(R.id.texto_nombre);
        TextView texto_valor = row.findViewById(R.id.texto_valor);
        TextView text_year = row.findViewById(R.id.txt_year);
        TextView text_month = row.findViewById(R.id.txt_month);
        TextView text_day = row.findViewById(R.id.txt_day);

        ArrayList<Transaccion> transacciones = lista;
        if (transacciones != null && position < transacciones.size()) {
            texto_nombre.setText(transacciones.get(position).getNombre());
            texto_valor.setText(transacciones.get(position).getValorFormateado());
            String[] fecha = transacciones.get(position).getFecha().split("/");
            text_year.setText(fecha[2]);
            text_month.setText(mesesMapa.get(fecha[1]));
            text_day.setText(fecha[0]);
        }

        return row;
    }
}
