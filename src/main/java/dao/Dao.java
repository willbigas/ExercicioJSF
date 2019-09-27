package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Dao {
    private EntityManagerFactory emf;

    public EntityManager getEntityManager() {

        return emf.createEntityManager();
    }

    public Dao() {
        //chamo ele de reprodutor da instância
        emf = Persistence.createEntityManagerFactory("Pessoas-PU");
    }
}

