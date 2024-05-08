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

public class AgregarGasto extends AppCompatActivity {

    EditText nombre_gasto;
    EditText vlr_gasto;
    EditText fecha_gasto;
    Button btn_agregar_gasto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_agregar_gasto);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    nombre_gasto = findViewById(R.id.input_nombre_gasto);
    vlr_gasto = findViewById(R.id.input_vlr_ingreso);
    fecha_gasto  = findViewById(R.id.input_fecha_ingreso);
    btn_agregar_gasto = findViewById(R.id.btn_agregar_ingreso);


    btn_agregar_gasto.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(AgregarIngreso.this, "Nombre: "+ nombre_gasto.getText().toString() + "vlr ingreso: " + vlr_gasto.getText().toString(), Toast.LENGTH_SHORT).show();
        }
    });
}
}