package util;

import model.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {
    private final static SessionFactory FACTORY;
    static {
        Configuration conf=new Configuration();
        Properties pros=new Properties();
        pros.put(Environment.DRIVER,"org.postgresql.Driver");
        pros.put(Environment.URL,"jdbc:postgresql://foodwebaws.cplzny1pvjlv.us-east-1.rds.amazonaws.com:5432/foodweb");
        pros.put(Environment.USER,"postgres");
        pros.put(Environment.PASS,"12345678");
        conf.setProperties(pros);
        conf.addAnnotatedClass(User.class);
        conf.addAnnotatedClass(Food.class);
        conf.addAnnotatedClass(Catalog.class);
        conf.addAnnotatedClass(Gallerie.class);


        ServiceRegistry registry
                =new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties())
                .build();
        FACTORY=conf.buildSessionFactory(registry);
        System.out.println("Hibernate Java Config serviceRegistry created");
    }
    public static SessionFactory getSessionFactory(){
        return FACTORY;
    }
}