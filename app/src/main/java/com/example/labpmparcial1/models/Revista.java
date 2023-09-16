package com.example.labpmparcial1.models;

public class Revista extends Publicacion{

    public Revista(){}
    public Revista(int codigoPublicacion, String tituloPublicacion, int anioPublicacion, int numeroRevista){
        super(codigoPublicacion, tituloPublicacion, anioPublicacion);
        this.numeroRevista = numeroRevista;
    }
    int numeroRevista;

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
}
