package com.example.labpmparcial1.services;


import com.example.labpmparcial1.repositories.PublicacionRespository;

public class ServiceLocator {
    private static ServiceLocator instance = null;
    private static PublicacionRespository PublicacionRepositoryinstance = null;

    private ServiceLocator() {}

    public static ServiceLocator getInstance() {
        if (instance == null) {
            synchronized(ServiceLocator.class) {
                instance = new ServiceLocator();
            }
        }
        return instance;
    }

    public PublicacionRespository getDBSource() {
        if (PublicacionRepositoryinstance == null) {
            synchronized(ServiceLocator.class) {
                PublicacionRepositoryinstance = new PublicacionRespository();
            }
        }
        return PublicacionRepositoryinstance;
    }
}

