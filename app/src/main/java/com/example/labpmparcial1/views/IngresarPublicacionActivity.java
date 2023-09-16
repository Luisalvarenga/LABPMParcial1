package com.example.labpmparcial1.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.labpmparcial1.R;

public class IngresarPublicacionActivity extends AppCompatActivity {

    Button btnLibro, btnRevista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar_publicacion);

        btnLibro = findViewById(R.id.btnLibro);
        btnRevista = findViewById(R.id.btnRevista);

        btnLibro.setOnClickListener(v -> {
            startActivity(new Intent(IngresarPublicacionActivity.this, LibroActivity.class));
        });

        btnRevista.setOnClickListener(v -> {
            startActivity(new Intent(IngresarPublicacionActivity.this, RevistaActivity.class));
        });
    }
}