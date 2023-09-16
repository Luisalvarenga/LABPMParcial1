package com.example.labpmparcial1.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.labpmparcial1.R;
import com.example.labpmparcial1.models.Libro;
import com.example.labpmparcial1.repositories.PublicacionRespository;
import com.example.labpmparcial1.services.ServiceLocator;

import java.util.List;

public class ListaLibrosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_libros);
        PublicacionRespository dbSource = ServiceLocator.getInstance().getDBSource();
        List<Libro> listaLibros = dbSource.getAllListLibros();

        ListView listView = findViewById(R.id.listView);

        // Crear un ArrayAdapter para mostrar la lista de libros en el ListView
        ArrayAdapter<Libro> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaLibros);

        // Asignar el ArrayAdapter al ListView
        listView.setAdapter(adapter);
    }
}