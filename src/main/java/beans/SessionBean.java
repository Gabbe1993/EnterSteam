package beans;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import util.Log;

import javax.ejb.Stateful;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gabri on 2016-06-09.
 */

@Stateful(name = "SessionEJB")
public class SessionBean implements Serializable{

    private SessionFactory sessionFactory;

    @Inject
    public SessionBean() {
       createSessionFactory();
    }

    public SessionFactory createSessionFactory() {
        try{
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }

        return sessionFactory;
    }

    public void insertArtist(String name) {
        Log.info("SessionBean.insertArtist");
        Log.info("name = [" + name + "]");
    }

    public List selectArtist(String name) {
        Log.info("SessionBean.selectArtist");
        Log.info("name = [" + name + "]");

        return new ArrayList();
    }
}
