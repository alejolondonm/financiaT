package com.financiat.upb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button btn_ir_creditos;
    private ConstraintLayout btn_ir_ingresos;
    private Datos datos;

    private TextView txt_ingresos;
    private TextView txt_gastos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        datos = (Datos) this.getApplication();
        txt_ingresos = findViewById(R.id.txt_ingresos);
        txt_gastos = findViewById(R.id.txt_gastos);

        txt_ingresos.setText(datos.getIngresos());
        txt_gastos.setText(datos.getGastos());
        btn_ir_creditos = findViewById(R.id.btn_ir_creditos);
        btn_ir_ingresos =  findViewById(R.id.btn_ir_ingresos);
        btn_ir_creditos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siguiente = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(siguiente);

            }
        });

        btn_ir_ingresos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siguiente = new Intent(MainActivity.this, AgregarIngreso.class);
                startActivity(siguiente);
            }
        });
    }
}