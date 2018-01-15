package auto.DAO;

import auto.logic.Car;
import auto.logic.Room;

import java.sql.SQLException;
import java.util.Collection;

public interface RoomDAO {

    public void addRoom(Room room) throws SQLException;
    public void updateRoom(Long room_id, Room room) throws SQLException;
    public Room getRoomBuId(Long room_id) throws SQLException;
    public Collection getAllRooms() throws SQLException;
    public void deleteRoom(Room room) throws SQLException;
    public Collection getRoomByCar(Car car) throws SQLException;

}
