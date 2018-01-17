package cars.whosecar.dao;
import cars.whosecar.model.Car;
import cars.whosecar.model.Room;

import java.util.List;

public interface RoomDao {
    public void save(Room p);
    public List<Room> getRoomsList();
    public List<Room> getRoomsByNumber(int n);
    public Room getRoomById(Long car_id);
    public void addCar(int roomNumber, Car car);
}