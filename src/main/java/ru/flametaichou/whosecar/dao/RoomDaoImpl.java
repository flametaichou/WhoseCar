package ru.flametaichou.whosecar.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.flametaichou.whosecar.model.Car;
import ru.flametaichou.whosecar.model.Room;

public class RoomDaoImpl implements RoomDao {
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public void save(Room room) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(room);
        tx.commit();
        session.close();
    }
    @Override
    public void delete(Room room) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(room);
        tx.commit();
        session.close();
    }
    @Override
    public List<Room> getRoomsList() {
        Session session = this.sessionFactory.openSession();
        String hql = "from Room";
        List<Room> roomList = session.createQuery(hql).list();
        session.close();
        return roomList;
    }

    @Override
    public Room getRoomByNumber(int n) {
        Session session = this.sessionFactory.openSession();
        String hql = "from Room where roomNumber = :Number";
        List<Room> roomsList = session.createQuery(hql).setInteger("Number", n).list();
        Room room = roomsList.get(0);
        session.close();
        return room;
    }

    @Override
    public Room getRoomById(Long room_id) {
        Session session = this.sessionFactory.openSession();
        Room room = (Room) session.get(Room.class, room_id);
        session.close();
        return room;
    }

    @Override
    public void addCar(int roomNumber, Car car) {
        Session session = this.sessionFactory.openSession();
        //load
        String hql = "from Room where roomNumber = :Number";
        List<Room> roomsList = session.createQuery(hql).setInteger("Number", roomNumber).list();
        Room room = roomsList.get(0);
        List<Car> carList = room.getCars();
        carList.add(car);
        room.setCars(carList);
        //save
        Transaction tx = session.beginTransaction();
        session.persist(room);
        tx.commit();
        session.close();
    }

    @Override
    public void addCarByNumber(int roomNumber, String carNumber) {
        Session session = this.sessionFactory.openSession();
        //load
        String hql = "from Room where roomNumber = :Number";
        List<Room> roomsList = session.createQuery(hql).setInteger("Number", roomNumber).list();
        Room room = roomsList.get(0);
        hql = "from Car where carNumber = :Number";
        List<Car> carsList = session.createQuery(hql).setString("Number", carNumber).list();
        Car car = carsList.get(0);
        List<Car> roomCarsList = room.getCars();
        roomCarsList.add(car);
        room.setCars(roomCarsList);
        //save
        Transaction tx = session.beginTransaction();
        session.persist(room);
        tx.commit();
        session.close();
    }

    @Override
    public void removeCarByNumber(int roomNumber, String carNumber) {
        Session session = this.sessionFactory.openSession();
        //load
        String hql = "from Room where roomNumber = :Number";
        List<Room> roomsList = session.createQuery(hql).setInteger("Number", roomNumber).list();
        Room room = roomsList.get(0);
        hql = "from Car where carNumber = :Number";
        List<Car> carsList = session.createQuery(hql).setString("Number", carNumber).list();
        Car car = carsList.get(0);
        List<Car> roomCarsList = room.getCars();
        roomCarsList.remove(roomCarsList.indexOf(car));
        room.setCars(roomCarsList);
        //save
        Transaction tx = session.beginTransaction();
        session.persist(room);
        tx.commit();
        session.close();
    }

}