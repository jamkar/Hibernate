import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.dto.UserDetails;

/**
 * Created by Karen on 13-Jul-17.
 */
public class HibernateTest_NamedQueries {

    private static final SessionFactory sessionFactory =
            new Configuration().configure().buildSessionFactory();

    private static Session getSession(){
        return sessionFactory.openSession();
    }

    public static void main(String[] args) {

        Session session = getSession();
        session.beginTransaction();

        Query query = session.getNamedQuery("UserDetails.byId");
        query.setInteger(0, 2);

        UserDetails user = (UserDetails) query.uniqueResult();
        System.out.println(user.getUsername());


        Query query1 = session.getNamedQuery("UserDetails.byName");
        query1.setString(0, "tertertertert");

        user = (UserDetails) query1.uniqueResult();
        System.out.println(user.getId());

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

}
