package auto.DAO.Impl;

import auto.DAO.CarDAO;
import auto.logic.Car;
import auto.logic.Room;
import auto.use.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CarDAOImpl implements CarDAO {
    @Override
    public void addCar(Car car) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(car);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog ( null , e.getMessage (), "Ошибка при вставке" , JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void updateCar(Long car_id, Car car) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(car);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog ( null , e.getMessage (), "Ошибка при вставке" , JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Car getCarBuId(Long car_id) throws SQLException {
        Session session = null;
        Car car = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            car = (Car) session.load(Car.class, car_id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog ( null , e.getMessage (), "Ошибка find by id" , JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return car;
    }

    @Override
    public Collection getAllCars() throws SQLException {
        Session session = null;
        Collection cars = new ArrayList<Car>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            cars = session.createCriteria(Car.class ).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog ( null , e.getMessage (), "Ошибка get all" , JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return cars;
    }

    @Override
    public void deleteCar(Car car) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(car);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog ( null , e.getMessage (), "Ошибка при удалении" , JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Collection getCarsByRoom(Room room) throws SQLException {
        Session session = null;
        List cars = new ArrayList<Car>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            int room_id = room.getId();
            Query query = session.createQuery("FROM Car WHERE room_id = :roomId").setLong("roomId", room_id);
            cars = (List<Car>) query.list();
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return cars;
    }
}
