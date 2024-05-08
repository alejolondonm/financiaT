package com.financiat.upb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ListaGastos extends AppCompatActivity {

    private ListView listViewGastos;
    private CustomListAdapter adaptador;
    private ImageView btn_volver_home_lista;
    private Datos datos;

    private Button btn_ir_agregar_gasto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista_gastos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        listViewGastos = findViewById(R.id.list_view_gastos);
        btn_ir_agregar_gasto = findViewById(R.id.btn_ir_agregar_gasto);
        datos = (Datos) getApplication();


        ArrayList<Transaccion> listaTransacciones = datos.getListaGastos();

        adaptador = new CustomListAdapter(this, R.layout.list_item, R.id.texto_nombre, listaTransacciones);

        listViewGastos.setAdapter(adaptador);

        btn_volver_home_lista = findViewById(R.id.btn_volver_home_lista);

        btn_volver_home_lista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siguiente = new Intent(ListaGastos.this, MainActivity.class);
                startActivity(siguiente);
            }
        });

        btn_ir_agregar_gasto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siguiente = new Intent(ListaGastos.this, AgregarGasto.class);
                startActivity(siguiente);
            }
        });
    }
}
