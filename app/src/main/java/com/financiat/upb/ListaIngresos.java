package com.financiat.upb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ListaIngresos extends AppCompatActivity {

    private ListView listViewTransacciones;
    private CustomListAdapter adaptador;
    private ImageView btn_volver_home_lista;
    private Datos datos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista_ingresos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        listViewTransacciones = findViewById(R.id.list_view_transacciones);

       datos = (Datos) getApplication();

        datos.addIngreso(new Transaccion("Sueldo", 100000,2));
        datos.addIngreso(new Transaccion("Inversiones", 200000,4));
        ArrayList<Transaccion> listaTransacciones = datos.getListaIngresos();

        adaptador = new CustomListAdapter(this, R.layout.list_item, R.id.texto_nombre, listaTransacciones);

        listViewTransacciones.setAdapter(adaptador);

        btn_volver_home_lista = findViewById(R.id.btn_volver_home_lista);

        btn_volver_home_lista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siguiente = new Intent(ListaIngresos.this, MainActivity.class);
                startActivity(siguiente);
            }
        });
    }
}
