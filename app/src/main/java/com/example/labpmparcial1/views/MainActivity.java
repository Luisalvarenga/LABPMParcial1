package com.example.labpmparcial1.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.labpmparcial1.R;

public class MainActivity extends AppCompatActivity {
    private Button btnAgregar, btnLista,btnAcerca;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAgregar = findViewById(R.id.btnAgregar);

        btnLista = findViewById(R.id.btnLista);

        btnAcerca = findViewById(R.id.btnAcerca);

        btnAgregar.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, IngresarPublicacionActivity.class));
        });

        btnLista.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, MostrarListaActivity.class));

        });
        btnAcerca.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                // Crear un Intent para ir a la otra actividad
                Intent intent = new Intent(MainActivity.this, AcercaDe.class);
                startActivity(intent);
            }
        });


    }
}