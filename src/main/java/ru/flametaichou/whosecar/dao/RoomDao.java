package ru.flametaichou.whosecar.dao;

import ru.flametaichou.whosecar.model.Car;
import ru.flametaichou.whosecar.model.Room;

import java.util.List;

public interface RoomDao {
    public void save(Room p);
    public void delete(Room p);
    public List<Room> getRoomsList();
    public Room getRoomByNumber(int n);
    public Room getRoomById(Long car_id);

    public void addCar(int roomNumber, Car car);
    public void addCarByNumber(int roomNumber, String carNumber);
    public void removeCarByNumber(int roomNumber, String carNumber);

}