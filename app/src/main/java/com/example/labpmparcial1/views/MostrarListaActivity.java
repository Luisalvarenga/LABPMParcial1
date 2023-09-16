package com.example.labpmparcial1.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.labpmparcial1.R;

public class MostrarListaActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    private Button btnContinuar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_lista);
        radioGroup = findViewById(R.id.radioGroup);
        btnContinuar = findViewById(R.id.btnContinuar);
        btnContinuar.setEnabled(false); // Deshabilitar el botón al inicio

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton selectedRadioButton = findViewById(checkedId);
                btnContinuar.setEnabled(selectedRadioButton != null);
            }
        });

        btnContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedId);

                String selectedOption = selectedRadioButton.getText().toString();

                if (selectedOption.equals("Libro")) {
                    Intent intent = new Intent(MostrarListaActivity.this, ListaLibrosActivity.class);
                    startActivity(intent);
                } else if (selectedOption.equals("Revista")) {
                    Intent intent = new Intent(MostrarListaActivity.this, ListaRevistasActivity.class);
                    startActivity(intent);
                } else if (selectedOption.equals("Ambos")) {
                    Intent intent = new Intent(MostrarListaActivity.this, ListaAmbosActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}