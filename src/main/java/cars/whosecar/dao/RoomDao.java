package cars.whosecar.dao;
import cars.whosecar.model.Room;

import java.util.List;

public interface RoomDao {
    public void save(Room p);
    public List<Room> getPersonList();
}