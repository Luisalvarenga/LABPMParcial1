package com.example.labpmparcial1.views;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.labpmparcial1.R;
import com.example.labpmparcial1.models.Libro;
import com.example.labpmparcial1.models.Publicacion;
import com.example.labpmparcial1.repositories.PublicacionRespository;
import com.example.labpmparcial1.services.ServiceLocator;

import java.util.List;

public class ListaAmbosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_ambos);

        PublicacionRespository dbSource = ServiceLocator.getInstance().getDBSource();
        List<Publicacion> listaPublicaciones = dbSource.getAllListPublicaciones();
        ListView listViewTodos = findViewById(R.id.listViewTodos);
        ArrayAdapter<Publicacion> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaPublicaciones);
        listViewTodos.setAdapter(adapter);

        listViewTodos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ListaAmbosActivity.this);
                builder.setTitle("Eliminar publicación");
                builder.setMessage("¿Estás seguro de que quieres eliminar a esta publicación?");

                builder.setPositiveButton("Eliminar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Publicacion publicacionEncontrada = (Publicacion)listViewTodos.getAdapter().getItem((int)id);
                        dbSource.DeletePublicacion(publicacionEncontrada.getCodigoPublicacion());

                        adapter.clear();
                        adapter.addAll(dbSource.getAllListPublicaciones());
                    }
                });

                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.create().show();
                return true;
            }
        });
    }
}