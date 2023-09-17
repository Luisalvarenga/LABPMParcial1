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
                String codigoPublicacion = etCodigoPublicacion.getText().toString();
                String tituloPublicacion = etTituloPublicacion.getText().toString();
                String anioPublicacion = etAnioPublicacion.getText().toString();

                if (codigoPublicacion.isEmpty() || tituloPublicacion.isEmpty() || anioPublicacion.isEmpty()) {
                    Toast.makeText(LibroActivity.this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Validar que el código de publicación tenga una longitud específica
                if (codigoPublicacion.length() != 6) {
                    Toast.makeText(LibroActivity.this, "El código de publicación debe tener 6 caracteres", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Validar que anioPublicacion sea un número
                try {
                    int anio = Integer.parseInt(anioPublicacion);
                } catch (NumberFormatException e) {
                    Toast.makeText(LibroActivity.this, "Año de publicación debe ser un número entero", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Validar el título de publicación
                if (tituloPublicacion.length() < 5) {
                    Toast.makeText(LibroActivity.this, "El título debe tener al menos 5 caracteres", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Aquí puedes proceder con la inserción del libro
                dbSource.AddPublicacion(new Libro(
                        Integer.parseInt(codigoPublicacion),
                        tituloPublicacion,
                        Integer.parseInt(anioPublicacion),
                        cbEstadoPrestamo.isChecked()
                ));

                Toast.makeText(LibroActivity.this, "Inserción de libro exitosa", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}