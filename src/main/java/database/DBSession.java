package database;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/**
 * Created by gabri on 2016-02-14.
 */

@Named("dbSession")
@SessionScoped
public class DBSession {
    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure()
                    .buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
