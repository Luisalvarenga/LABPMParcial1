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
import com.example.labpmparcial1.models.Revista;
import com.example.labpmparcial1.repositories.PublicacionRespository;
import com.example.labpmparcial1.services.ServiceLocator;

public class RevistaActivity extends AppCompatActivity {

    private PublicacionRespository dbSource = ServiceLocator.getInstance().getDBSource();

    EditText etCodigoPublicacion, etTituloPublicacion, etAnioPublicacion, etNumeroRevista;
    Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revista);

        etCodigoPublicacion = findViewById(R.id.etCodigoPublicacion);
        etTituloPublicacion = findViewById(R.id.etTituloPublicacion);
        etAnioPublicacion = findViewById(R.id.etAnioPublicacion);
        etNumeroRevista = findViewById(R.id.etNumeroRevista);
        btnGuardar = findViewById(R.id.btnGuardar);


        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String codigoPublicacion = etCodigoPublicacion.getText().toString();
                String tituloPublicacion = etTituloPublicacion.getText().toString();
                String anioPublicacion = etAnioPublicacion.getText().toString();
                String numeroRevista = etNumeroRevista.getText().toString();

                if (codigoPublicacion.isEmpty() || tituloPublicacion.isEmpty() || anioPublicacion.isEmpty() || numeroRevista.isEmpty()) {
                    Toast.makeText(RevistaActivity.this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Validar que codigoPublicacion tenga una longitud específica
                if (codigoPublicacion.length() != 6) {
                    Toast.makeText(RevistaActivity.this, "El código de publicación debe tener 6 caracteres", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Validar el título de publicación
                if (tituloPublicacion.length() < 5) {
                    Toast.makeText(RevistaActivity.this, "El título debe tener al menos 5 caracteres", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Validar que anioPublicacion y numeroRevista sean números
                try {
                    int anio = Integer.parseInt(anioPublicacion);
                    int numero = Integer.parseInt(numeroRevista);
                } catch (NumberFormatException e) {
                    Toast.makeText(RevistaActivity.this, "Año y número de revista deben ser números enteros", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Aquí puedes proceder con la inserción de la revista
                dbSource.AddPublicacion(new Revista(
                        Integer.parseInt(codigoPublicacion),
                        tituloPublicacion,
                        Integer.parseInt(anioPublicacion),
                        Integer.parseInt(numeroRevista)
                ));

                Toast.makeText(RevistaActivity.this, "Inserción de revista exitosa", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
}