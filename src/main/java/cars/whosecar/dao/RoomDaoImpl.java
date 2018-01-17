package cars.whosecar.dao;
import cars.whosecar.model.Car;
import cars.whosecar.model.Room;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

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
    public List<Room> getRoomsList() {
        Session session = this.sessionFactory.openSession();
        String hql = "from Room";
        List<Room> roomList = session.createQuery(hql).list();
        session.close();
        return roomList;
    }

    @Override
    public List<Room> getRoomsByNumber(int n) {
        Session session = this.sessionFactory.openSession();
        String hql = "from Room where roomNumber = :Number";
        List<Room> roomsList = session.createQuery(hql).setInteger("Number", n).list();
        session.close();
        return roomsList;
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
}