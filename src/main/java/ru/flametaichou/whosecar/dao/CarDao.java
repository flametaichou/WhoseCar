package ru.flametaichou.whosecar.dao;

import ru.flametaichou.whosecar.model.Car;
import ru.flametaichou.whosecar.model.Room;

import java.util.List;

public interface CarDao {
    public void save(Car c);
    public void delete(Car c);
    public List<Car> getCarsList();
    public Car getCarByNumber(String n);
    public List<Car> getCarsByNumber(String n);
    public List<Car> getCarsByRoomNumber(String n);
    public Car getCarById(Long car_id);
    public void addRoom(String carNumber, Room room);
    public void addRoomByNumber(String carNumber, int roomNumber);
    public void removeRoomByNumber(String carNumber);
}
