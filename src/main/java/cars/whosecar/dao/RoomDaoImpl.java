package cars.whosecar.dao;
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
    public List<Room> getPersonList() {
        Session session = this.sessionFactory.openSession();
        String hql = "from Room";
        List<Room> roomList = session.createQuery(hql).list();
        session.close();
        return roomList;
    }
}