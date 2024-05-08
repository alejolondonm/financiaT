package com.financiat.upb;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AgregarIngreso extends AppCompatActivity {

    EditText nombre_ingreso;
    EditText vlr_ingreso;
    EditText fecha_ingreso;
    Button btn_ingresar;

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
        btn_ingresar = findViewById(R.id.btn_agregar_ingreso);


    btn_ingresar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(AgregarIngreso.this, "Nombre: "+ nombre_ingreso.getText().toString() + "vlr ingreso: " + vlr_ingreso.getText().toString(), Toast.LENGTH_SHORT).show();
        }
    });
    }
}