import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.dto.UserDetails;

import java.util.List;

/**
 * Created by Karen on 14-Jul-17.
 */
public class HibernateTest_Caching {

    private static final SessionFactory sessionFactory =
            new Configuration().configure().buildSessionFactory();

    private static Session getSession() {
        return sessionFactory.openSession();
    }

    public static void main(String[] args) {

        Session session = getSession();
        session.beginTransaction();

        //Fetches data using first-level cache (session based)
//        UserDetails userDetails = (UserDetails) session.get(UserDetails.class, 1);
//        UserDetails userDetails1 = (UserDetails) session.get(UserDetails.class, 1);

        //Query cache
        Query query = session.createQuery("from UserDetails user where id=1");
        query.setCacheable(true);
        List<UserDetails> userList = query.list();

        session.getTransaction().commit();
        session.close();

        //Fetches data using second-level cache (EhCache)
        Session session1 = getSession();
        session1.beginTransaction();

//        UserDetails userDetails2 = (UserDetails) session1.get(UserDetails.class, 1);

        //Query cache
        Query query1 = session1.createQuery("from UserDetails user where id=1");
        query1.setCacheable(true);
        userList = query1.list();

        session1.getTransaction().commit();
        session1.close();

        sessionFactory.close();
    }

}
