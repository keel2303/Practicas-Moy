package com.example.pasardatosjava;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etName, etAge;
    CheckBox cbStudent;
    Button btnPrimitivos, btnParcelable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        cbStudent = findViewById(R.id.cbStudent);
        btnPrimitivos = findViewById(R.id.btnEnviarPrimitivos);
        btnParcelable = findViewById(R.id.btnEnviarParcelable);

        // Enviar datos simples
        btnPrimitivos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nombre = etName.getText().toString();
                int edad = Integer.parseInt(etAge.getText().toString());
                boolean estudiante = cbStudent.isChecked();

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("nombre", nombre);
                intent.putExtra("edad", edad);
                intent.putExtra("estudiante", estudiante);

                startActivity(intent);
            }
        });

        // Enviar Parcelable
        btnParcelable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nombre = etName.getText().toString();
                int edad = Integer.parseInt(etAge.getText().toString());
                boolean estudiante = cbStudent.isChecked();

                Persona persona = new Persona(nombre, edad, estudiante);

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("persona", persona);

                startActivity(intent);
            }
        });
    }
}
