import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.javabrains.dto.UserDetails;

import java.util.List;

/**
 * Created by Karen on 13-Jul-17.
 */
public class HibernateTest_Criteria {

    private static final SessionFactory sessionFactory =
            new Configuration().configure().buildSessionFactory();

    private static Session getSession() {
        return sessionFactory.openSession();
    }

    public static void main(String[] args) {

        Session session = getSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(UserDetails.class).
                setProjection(Projections.count("id"));
        criteria.add(Restrictions.eq("username", "Anna"));

//        System.out.println(criteria.list());

        List<UserDetails> users = criteria.list();

        for(UserDetails u : users) {
            System.out.println(u.getUsername());
        }

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

    }

}
