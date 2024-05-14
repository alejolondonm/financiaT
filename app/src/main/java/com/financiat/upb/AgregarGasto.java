package com.financiat.upb;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AgregarGasto extends AppCompatActivity {


    LinearLayout mainLayout;
    private EditText nombre_gasto;
    private EditText vlr_gasto;
    private EditText fecha_gasto;
    private Button btn_agregar_gasto;
    private ImageView btn_volver_home;

    private Datos datos;
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

        nombre_gasto = findViewById(R.id.input_nombre_gasto);
        vlr_gasto = findViewById(R.id.input_vlr_gasto);
        fecha_gasto  = findViewById(R.id.input_fecha_gasto);

        btn_agregar_gasto = findViewById(R.id.btn_agregar_gasto);
        btn_volver_home = findViewById(R.id.btn_volver_home);
        datos = (Datos)getApplication();
        btn_agregar_gasto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double valorGasto = Double.parseDouble(vlr_gasto.getText().toString());
                int fechaGasto = Integer.parseInt(fecha_gasto.getText().toString());
                datos.addGasto(new Transaccion(nombre_gasto.getText().toString(), valorGasto, fechaGasto));

                Intent siguiente = new Intent(AgregarGasto.this, ListaGastos.class);
                startActivity(siguiente);
            }
        });

        mainLayout = findViewById(R.id.main);
        mainLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                    return true;
                }
                return false;
            }
        });

        btn_volver_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siguiente = new Intent(AgregarGasto.this, MainActivity.class);
                startActivity(siguiente);
            }
        });
    }
}