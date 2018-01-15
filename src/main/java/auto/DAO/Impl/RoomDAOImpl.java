package auto.DAO.Impl;

import auto.DAO.RoomDAO;
import auto.logic.Car;
import auto.logic.Room;
import auto.logic.Room;
import auto.use.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RoomDAOImpl implements RoomDAO {
    @Override
    public void addRoom(Room room) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(room);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }


    @Override
    public void updateRoom(Long room_id, Room room) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(room);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Room getRoomBuId(Long room_id) throws SQLException {
        Session session = null;
        Room room = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            room = (Room) session.load(Room.class, room_id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка find by id", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return room;
    }

    @Override
    public Collection getAllRooms() throws SQLException {
        Session session = null;
        Collection rooms = new ArrayList<Room>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            rooms = session.createCriteria(Room.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка get all", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return rooms;
    }

    @Override
    public void deleteRoom(Room room) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(room);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при удалении", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Collection getRoomByCar(Car car) throws SQLException {
        Session session = null;
        List rooms = new ArrayList<Room>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            int car_id = car.getId();
            Query query = session.createQuery("FROM Room WHERE car_id = :carId").setLong("carId", car_id);
            rooms = (List<Room>) query.list();
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return rooms;
    }
}