import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.dto.FourWheelVehicle;
import org.javabrains.dto.TwoWheelVehicle;
import org.javabrains.dto.Vehicle;

/**
 * Created by Karen on 09-Jul-17.
 */
public class HibernateTest_Inheritance {

    private static SessionFactory sessionFactory =
            new Configuration().configure().buildSessionFactory();

    private static Session getSession() {
        return sessionFactory.openSession();
    }


    public static void main(String[] args) {

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleName("Car");

        TwoWheelVehicle twoWheelVehicle = new TwoWheelVehicle();
        twoWheelVehicle.setVehicleName("moto");
        twoWheelVehicle.setSteeringHandle("moto steering handle");

        FourWheelVehicle fourWheelVehicle = new FourWheelVehicle();
        fourWheelVehicle.setVehicleName("audi");
        fourWheelVehicle.setSteeringWheel("audi steering wheel");

        Session session = getSession();
        session.beginTransaction();

        session.save(vehicle);
        session.save(twoWheelVehicle);
        session.save(fourWheelVehicle);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
