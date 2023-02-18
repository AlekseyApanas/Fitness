package dao.orm.manager;

import dao.orm.api.IManager;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class Manager implements IManager {
    private EntityManagerFactory factory;

    public Manager() {
        this.factory = Persistence.createEntityManagerFactory("fitness");
    }

    public EntityManager getEntityManager(){
        return this.factory.createEntityManager();
    }

    public void close() {
        this.factory.close();
    }
}
