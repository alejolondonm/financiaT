package com.financiat.upb;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class AgregarIngreso extends AppCompatActivity {

    LinearLayout mainLayout;

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


        btn_agregar_ingreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = nombre_ingreso.getText().toString();
                String valor = vlr_ingreso.getText().toString();
                String fecha = fecha_ingreso.getText().toString();

                if (nombre.isEmpty()) {
                    // Mostrar un mensaje indicando que el campo Nombre de Gasto está vacío
                    Toast.makeText(AgregarIngreso.this, "Por favor ingrese el nombre del gasto", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (valor.isEmpty()) {
                    // Mostrar un mensaje indicando que el campo Valor de Gasto está vacío
                    Toast.makeText(AgregarIngreso.this, "Por favor ingrese el valor del gasto", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    double valorGasto = Double.parseDouble(valor);
                } catch (NumberFormatException e) {
                    // Mostrar un mensaje indicando que el valor ingresado no es válido
                    Toast.makeText(AgregarIngreso.this, "El valor del gasto no es válido", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!isValidDateFormat(fecha)) {
                    // Mostrar un mensaje indicando que el formato de fecha no es válido
                    Toast.makeText(AgregarIngreso.this, "El formato de la fecha no es válido. Debe ser DD/MM/AAAA", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Si todos los campos tienen valores válidos, agregar el gasto
                datos.addIngreso(new Transaccion(nombre, Double.parseDouble(valor), fecha));

                // Ir a la actividad ListaGastos
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
    private boolean isValidDateFormat(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

}