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
                dbSource.AddPublicacion(new Revista( Integer.parseInt(etCodigoPublicacion.getText().toString()),
                        etTituloPublicacion.getText().toString(),
                        Integer.parseInt(etAnioPublicacion.getText().toString()),
                        Integer.parseInt(etNumeroRevista.getText().toString()) ));

                Toast.makeText(RevistaActivity.this, "Inserción de revista exitosa", Toast.LENGTH_SHORT).show();
                finish();
            }
        });



    }
}