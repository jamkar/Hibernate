import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


/**
 * Created by Karen on 13-Jul-17.
 */
public class HibernateTest_Queries {

    private static final SessionFactory sessionFactory;

    static {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    private static Session getSession() {
        return sessionFactory.openSession();
    }

    public static void main(String[] args) {

        Session session = getSession();
        session.beginTransaction();

//        Query query = session.createQuery("from UserDetails ");
        Query query = session.createQuery(
                "select id, username from UserDetails where id < :userId");
        query.setInteger("userId", 3);

        // Pagination
//        query.setFirstResult(1);
//        query.setMaxResults(2);
//        List<UserDetails> users = query.list();

        List<Object[]> users = query.list();

        for (Object[] u : users) {
            System.out.println(u[0]+ " " + u[1]);
        }

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

}
