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

        lsvRevistas.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ListaRevistasActivity.this);
                builder.setTitle("Eliminar Revista");
                builder.setMessage("¿Estás seguro de que quieres eliminar a esta Revista?");

                builder.setPositiveButton("Eliminar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Revista revistaEncontrada = (Revista)lsvRevistas.getAdapter().getItem((int)id);
                        dbSource.DeleteRevista(revistaEncontrada.getCodigoPublicacion());

                        arrayAdapter.clear();
                        arrayAdapter.addAll(dbSource.getAllListRevistas());
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

    @Override
    protected void onResume() {
        arrayAdapter.notifyDataSetChanged();
        super.onResume();
    }
}