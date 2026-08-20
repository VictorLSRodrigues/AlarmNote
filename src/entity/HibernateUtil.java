package entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Wallace
 */
public class HibernateUtil {
    
    private static EntityManagerFactory instancia;
    private static EntityManager manager;
    
    private static final String NOME_BASE = "agenda";
    
    private static EntityManagerFactory getFactory() {
        if(instancia == null) {
            instancia = Persistence.createEntityManagerFactory(NOME_BASE);
        }
        return instancia;
    }
    
    public static EntityManager getManager() {
        if(manager == null || !manager.isOpen()) {
            manager = getFactory().createEntityManager();
        }
        return manager;
    }
}