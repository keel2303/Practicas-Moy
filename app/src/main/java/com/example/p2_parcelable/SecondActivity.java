package com.example.p2_parcelable;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvResultado = findViewById(R.id.tvResultado);

        Persona p = getIntent().getParcelableExtra("persona");

        String result = "Nombre: " + p.getNombre() + "\n" +
                "Edad: " + p.getEdad() + "\n" +
                "Soltero: " + (p.isSoltero() ? "Sí" : "No");

        tvResultado.setText(result);
    }
}
