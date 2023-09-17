package com.example.labpmparcial1.models;

public class Libro extends Publicacion implements IPrestable {
    boolean estadoPrestamo;

    public Libro(){

    }

    public Libro(int codigoPublicacion, String tituloPublicacion, int anioPublicacion, boolean estadoPrestamo){
        super(codigoPublicacion, tituloPublicacion, anioPublicacion);
        this.estadoPrestamo =  estadoPrestamo;
    }

    @Override
    public void prestar() {
        this.estadoPrestamo = true;
    }

    @Override
    public void devolver() {
        this.estadoPrestamo = false;
    }

    @Override
    public boolean prestado() {
        return this.estadoPrestamo;
    }

    @Override
    public int getTipoPublicacion(){
        return 1;
    }

    @Override
    public String toString() {
        return  this.codigoPublicacion + " " +this.tituloPublicacion + " " + this.anioPublicacion + " " + this.estadoPrestamo;
    }
}
