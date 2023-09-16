package com.example.labpmparcial1.repositories;

import com.example.labpmparcial1.models.Libro;
import com.example.labpmparcial1.models.Publicacion;
import com.example.labpmparcial1.models.Revista;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PublicacionRespository {

    List<Publicacion> mainList;


    public PublicacionRespository(){
        mainList = new ArrayList<>();
        Libro l1 = new Libro(1234, "r", 1234, true){};
        Revista r1 = new Revista(1234, "r", 1234, 12345){};

        mainList.add(l1);
        mainList.add(r1);

    }

    public List<Publicacion> getAllListPublicaciones(){
        return this.mainList;
    }

    public List<Libro> getAllListLibros(){
        List<Libro> libros = new ArrayList<>();

        for (Publicacion publicacion : mainList) {
            if (publicacion instanceof Libro) {
                libros.add((Libro) publicacion);
            }
        }
        return libros;
    }

    public List<Revista> getAllListRevistas(){
        List<Revista> revistas = new ArrayList<>();

        for (Publicacion publicacion : mainList) {
            if (publicacion instanceof Revista) {
                revistas.add((Revista) publicacion);
            }
        }
        return revistas;
    }

    public Publicacion getPublicacionById(int idMainObject){
        //return this.mainListPerson.stream().filter(person -> person.getIdPersona() == idMainObject).findFirst();
        for (Publicacion person : mainList) {
            if (person.getCodigoPublicacion() == idMainObject) {
                return person;
            }
        }
        return null;
    }

    public boolean AddPublicacion(Publicacion mainObject) {
        return this.mainList.add(mainObject);
    }

    public boolean EditPublicacion(Publicacion mainObject) {

        for (int i = 0; i < mainList.size(); i++) {
            Publicacion person = mainList.get(i);
            if (person.getCodigoPublicacion() == mainObject.getCodigoPublicacion()) {
                mainList.set(i, mainObject);
                return true;
            }
        }
        return false;
    }

    public boolean DeletePublicacion(int idMainObject){
        Publicacion objectToDelete = getPublicacionById(idMainObject);
        if (objectToDelete != null) {
            mainList.remove(objectToDelete);
            return true;
        }
        return false;
    }

}
