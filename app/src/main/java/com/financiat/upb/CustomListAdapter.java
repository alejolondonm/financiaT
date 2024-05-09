package com.financiat.upb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Button;
import java.util.ArrayList;

public class CustomListAdapter extends ArrayAdapter<Transaccion> {
    private ArrayList<Transaccion> lista;

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
        Button btn_dia = row.findViewById(R.id.button_dia);

        ArrayList<Transaccion> transacciones = lista;
        if (transacciones != null && position < transacciones.size()) {
            texto_nombre.setText(transacciones.get(position).getNombre());
            texto_valor.setText(transacciones.get(position).getValorFormateado());
            btn_dia.setText(String.valueOf(transacciones.get(position).getDia()));
        }

        return row;
    }
}
