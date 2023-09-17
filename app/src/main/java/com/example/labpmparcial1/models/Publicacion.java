package com.example.labpmparcial1.models;

public abstract class Publicacion {
    int codigoPublicacion;
    String tituloPublicacion;
    int anioPublicacion;

    public Publicacion(){}
    public Publicacion(int codigoPublicacion, String tituloPublicacion, int anioPublicacion){
        this.codigoPublicacion = codigoPublicacion;
        this.tituloPublicacion = tituloPublicacion;
        this.anioPublicacion = anioPublicacion;

    }

    public int getCodigoPublicacion() {
        return codigoPublicacion;
    }

    public void setCodigoPublicacion(int codigoPublicacion) {
        this.codigoPublicacion = codigoPublicacion;
    }

    public String getTituloPublicacion() {
        return tituloPublicacion;
    }

    public void setTituloPublicacion(String tituloPublicacion) {
        this.tituloPublicacion = tituloPublicacion;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public int getTipoPublicacion() {
        return 0;
    }

    @Override
    public String toString() {
        return  this.codigoPublicacion +" "+ this.tituloPublicacion + " " + this.anioPublicacion + " Tipo publicación: " + getTipoPublicacion();
    }
}
