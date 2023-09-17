package com.example.labpmparcial1.models;

public class Revista extends Publicacion{

    int numeroRevista;

    public Revista(){}
    public Revista(int codigoPublicacion, String tituloPublicacion, int anioPublicacion, int numeroRevista){
        super(codigoPublicacion, tituloPublicacion, anioPublicacion);
        this.numeroRevista = numeroRevista;
    }

    public int getNumeroRevista() {
        return numeroRevista;
    }

    public void setNumeroRevista(int numeroRevista) {
        this.numeroRevista = numeroRevista;
    }

    @Override
    public int getTipoPublicacion(){
        return 2;
    }

    @Override
    public String toString() {
        return  this.codigoPublicacion + " " + this.tituloPublicacion + " " + this.anioPublicacion + " " + this.numeroRevista;
    }
}
