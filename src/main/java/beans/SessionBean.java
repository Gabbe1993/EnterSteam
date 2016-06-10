package beans;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
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
    private ServiceRegistry serviceRegistry;

    @Inject
    public SessionBean() {
       createSessionFactory();
    }

    public SessionFactory createSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure();

        serviceRegistry = new ServiceRegistryBuilder().applySettings(
                configuration.getProperties()). buildServiceRegistry();

        // TODO: throws org.hibernate.service.classloading.spi.ClassLoadingException: Specified JDBC Driver com.mysql.jdbc.Driver could not be loaded
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

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
