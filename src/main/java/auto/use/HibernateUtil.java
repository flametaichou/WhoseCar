package auto.use;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

public class HibernateUtil {
    private final static SessionFactory sessionFactory;
    static {
        try {
            sessionFactory = new Configuration (). configure (). buildSessionFactory ();
        } catch (Throwable ex) {
            System.err.println ("Начальное создание SessionFactory не удалось." + ex);
            throw new ExceptionInInitializerError (ex);
        }
    }

    public static SessionFactory getSessionFactory () {
        return sessionFactory;
    }
}
