import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.dto.*;

import java.util.Date;

/**
 * Created by Karen on 06-Jul-17.
 */
public class HibernateTest {

    public static void main(String[] args) {
        User user = new User();
//        user.setUserId(1);
        user.setUserName("First User");
        user.setDescription("First User's description");
        user.setJoinedDate(new Date());

        Address address = new Address();
        address.setCity("Yerevan");
        address.setPincode("0098");
        address.setState("Yerevan");
        address.setStreet("Jrashen");
        Address address1 = new Address();
        address1.setCity("Krakow");
        address1.setPincode("0000");
        address1.setState("Krakow");
        address1.setStreet("dfjkdf");
        user.getAddressSet().add(address);
        user.getAddressSet().add(address1);

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleName("Car");
        user.setVehicle(vehicle);

        Book book1 = new Book();
        book1.setAuthor("Pushkin");
        book1.setName("Onegin");
        book1.setUser(user);
        Book book2 = new Book();
        book2.setAuthor("Twen");
        book2.setName("Tome Soyer");
        book2.setUser(user);
        user.getBooks().add(book1);
        user.getBooks().add(book2);

        House house = new House();
        house.setColor("Red");
        house.setSize("56");
        house.getUsers().add(user);
        House house1 = new House();
        house1.setColor("Green");
        house1.setSize("105");
        house1.getUsers().add(user);
        user.getHouses().add(house);
        user.getHouses().add(house1);

        //Persist model data
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(user);
        session.save(vehicle);
//        session.save(book1);
//        session.save(book2);
        session.save(house);
        session.save(house1);

        int userId =  user.getUserId();
        System.out.println("userId " + userId);

        session.getTransaction().commit();
        session.close();

        user = null;

        //Fetch model data
//        session = sessionFactory.openSession();

//        user = session.get(User.class, userId);
//        session.close(); //Throws LazyInitializationException if fetch type is LAZY
//        System.out.println(user.getAddressSet().size());
    }

}
