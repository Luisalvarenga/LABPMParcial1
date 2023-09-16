package com.example.labpmparcial1.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.labpmparcial1.R;
import com.example.labpmparcial1.models.Libro;
import com.example.labpmparcial1.repositories.PublicacionRespository;
import com.example.labpmparcial1.services.ServiceLocator;

public class LibroActivity extends AppCompatActivity {
    private PublicacionRespository dbSource = ServiceLocator.getInstance().getDBSource();

    EditText etCodigoPublicacion, etTituloPublicacion, etAnioPublicacion;
    CheckBox cbEstadoPrestamo;
    Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libro);

        etCodigoPublicacion = findViewById(R.id.etCodigoPublicacion);
        etTituloPublicacion = findViewById(R.id.etTituloPublicacion);
        etAnioPublicacion = findViewById(R.id.etAnioPublicacion);
        cbEstadoPrestamo = findViewById(R.id.cbEstadoPrestamo);
        btnGuardar = findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbSource.AddPublicacion(new Libro( Integer.parseInt(etCodigoPublicacion.getText().toString()),
                                                   etTituloPublicacion.getText().toString(),
                                                   Integer.parseInt(etAnioPublicacion.getText().toString()),
                                                   cbEstadoPrestamo.isChecked() ));

                Toast.makeText(LibroActivity.this, "Inserción de libro exitosa", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}