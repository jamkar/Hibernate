import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.dto.UserDetails;

/**
 * Created by Karen on 10-Jul-17.
 */
public class HibernateTest_CRUD {

    private static SessionFactory sessionFactory =
            new Configuration().configure().buildSessionFactory();

    private static Session getSession() {
        return sessionFactory.openSession();
    }

    public static void main(String[] args) {

        UserDetails userDetails = new UserDetails();
        userDetails.setUsername("jamkar");

        UserDetails userDetails1 = create(userDetails);
//        read(userDetails.getId());
        userDetails.setUsername("xyz");
//        userDetails.setId(3);
        System.out.println("id " + userDetails.getId());
        update(userDetails);

        sessionFactory.close();
    }

    private static UserDetails create(UserDetails userDetails) {
        Session session = getSession();
        session.beginTransaction();

        session.save(userDetails);

        //Hibernate keeps track of changes
//        userDetails.setUsername("abc");
//        userDetails.setUsername("def");

        session.getTransaction().commit();
        session.close();

        return userDetails;
    }

    private static UserDetails read(int id) {
        Session session = getSession();
        session.beginTransaction();

        UserDetails user = session.get(UserDetails.class, id);

        session.getTransaction().commit();
        session.close();

        System.out.println("Username pulled up is: " + user.getUsername());
        return user;
    }

    private static UserDetails update(UserDetails userDetails) {
        Session session = getSession();
        session.beginTransaction();

        session.update(userDetails);

        session.getTransaction().commit();
        session.close();

        return  userDetails;
    }

    private static void delete(UserDetails userDetails) {
        Session session = getSession();
        session.beginTransaction();

        session.delete(userDetails);

        session.getTransaction().commit();
        session.close();
    }
}
