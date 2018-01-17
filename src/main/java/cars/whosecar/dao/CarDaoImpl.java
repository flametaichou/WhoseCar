package cars.whosecar.dao;

import cars.whosecar.model.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class CarDaoImpl implements CarDao {
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public void save(Car car) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(car);
        tx.commit();
        session.close();
    }

    @Override
    public List<Car> getCarsList() {
        Session session = this.sessionFactory.openSession();
        String hql = "from Car";
        List<Car> carsList = session.createQuery(hql).list();
        session.close();
        return carsList;
    }

    @Override
    public List<Car> getCarsByNumber(String n) {
        Session session = this.sessionFactory.openSession();
        String hql = "from Car where carNumber = :Number";
        List<Car> carsList = session.createQuery(hql).setString("Number", n).list();
        session.close();
        return carsList;
    }

    @Override
    public Car getCarById(Long car_id) {
        Session session = this.sessionFactory.openSession();
        Car car = (Car) session.get(Car.class, car_id);
        session.close();
        return car;
    }
}
