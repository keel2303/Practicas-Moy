package com.example.pasardatosjava;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView tvPrimitivos, tvParcelable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvPrimitivos = findViewById(R.id.tvPrimitivos);
        tvParcelable = findViewById(R.id.tvParcelable);

        // Datos simples
        String nombre = getIntent().getStringExtra("nombre");
        int edad = getIntent().getIntExtra("edad", -1);
        boolean estudiante = getIntent().getBooleanExtra("estudiante", false);

        if (nombre != null) {
            tvPrimitivos.setText(
                    "Datos simples:\nNombre: " + nombre +
                            "\nEdad: " + edad +
                            "\nEstudiante: " + estudiante
            );
        }

        // Parcelable
        Persona p = getIntent().getParcelableExtra("persona");

        if (p != null) {
            tvParcelable.setText(
                    "Datos Parcelable:\nNombre: " + p.getNombre() +
                            "\nEdad: " + p.getEdad() +
                            "\nEstudiante: " + p.isEstudiante()
            );
        }
    }
}
