package com.example.labpmparcial1.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.labpmparcial1.R;
import com.example.labpmparcial1.models.Revista;
import com.example.labpmparcial1.repositories.PublicacionRespository;
import com.example.labpmparcial1.services.ServiceLocator;

public class ListaRevistasActivity extends AppCompatActivity {

    private PublicacionRespository dbSource = ServiceLocator.getInstance().getDBSource();
    ListView lsvRevistas;
    private ArrayAdapter<Revista> arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_revistas);

        lsvRevistas = findViewById(R.id.lsvRevistas);
        arrayAdapter = new ArrayAdapter<>
                (this, android.R.layout.simple_list_item_1, dbSource.getAllListRevistas());
        lsvRevistas.setAdapter(arrayAdapter);
    }
}