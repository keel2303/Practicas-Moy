package com.example.p2_parcelable;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etNombre, etEdad;
    CheckBox cbSoltero;
    Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = findViewById(R.id.etNombre);
        etEdad = findViewById(R.id.etEdad);
        cbSoltero = findViewById(R.id.cbSoltero);
        btnEnviar = findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(v -> {
            String nombre = etNombre.getText().toString();
            int edad = Integer.parseInt(etEdad.getText().toString());
            boolean soltero = cbSoltero.isChecked();

            Persona p = new Persona(nombre, edad, soltero);

            Intent i = new Intent(MainActivity.this, SecondActivity.class);
            i.putExtra("persona", p);
            startActivity(i);
        });
    }
}
