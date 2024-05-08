package com.financiat.upb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AgregarIngreso extends AppCompatActivity {

    private EditText nombre_ingreso;
    private EditText vlr_ingreso;
    private EditText fecha_ingreso;
    private Button btn_agregar_ingreso;
    private ImageView btn_volver_home;
private Datos datos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_agregar_ingreso);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        nombre_ingreso = findViewById(R.id.input_nombre_ingreso);
        vlr_ingreso = findViewById(R.id.input_vlr_ingreso);
        fecha_ingreso  = findViewById(R.id.input_fecha_ingreso);

        btn_agregar_ingreso = findViewById(R.id.btn_agregar_ingreso);
        btn_volver_home = findViewById(R.id.btn_volver_home);
        datos = (Datos)getApplication();
        btn_agregar_ingreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double valorIngreso = Double.parseDouble(vlr_ingreso.getText().toString());
                int fechaIngreso = Integer.parseInt(fecha_ingreso.getText().toString());
                datos.addIngreso(new Transaccion(nombre_ingreso.getText().toString(), valorIngreso, fechaIngreso));

                Intent siguiente = new Intent(AgregarIngreso.this, ListaIngresos.class);
                startActivity(siguiente);
            }
        });
        btn_volver_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siguiente = new Intent(AgregarIngreso.this, ListaIngresos.class);
                startActivity(siguiente);
            }
        });
    }
}