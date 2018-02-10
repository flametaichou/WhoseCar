package ru.flametaichou.whosecar.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.flametaichou.whosecar.dao.CarDao;
import ru.flametaichou.whosecar.dao.RoomDao;
import ru.flametaichou.whosecar.model.Car;
import ru.flametaichou.whosecar.model.Room;

import java.util.List;

public class DatabaseController {

    private static ClassPathXmlApplicationContext context;
    private static RoomDao roomDAO;
    private static CarDao carDAO;

    public DatabaseController() {
        context = new ClassPathXmlApplicationContext("META-INF/spring/beans.xml");
        roomDAO = context.getBean(RoomDao.class);
        carDAO = context.getBean(CarDao.class);
    }

    public static void close() {
        context.close();
    }

    public static void createRoom(int roomNumber) {
        Room room = new Room(roomNumber);
        roomDAO.save(room);
    }

    public static void createCar(String carNumber, String carBrand, String carColor) {
        Car car = new Car(carNumber,carBrand, carColor);
        carDAO.save(car);
    }

    public static void addCarToRoomByNumbers(int roomNumber, String carNumber) {
        roomDAO.addCarByNumber(roomNumber,carNumber);
        carDAO.addRoomByNumber(carNumber,roomNumber);
    }

    public static void removeCarFromRoom(int roomNumber, String carNumber) {
        roomDAO.removeCarByNumber(roomNumber,carNumber);
        carDAO.removeRoomByNumber(carNumber);
    }

    public static void deleteCarByNumber(String carNumber) {
        Car car = carDAO.getCarByNumber(carNumber);
        carDAO.delete(car);
    }

    public static void deleteRoomByNumber(int roomNumber) {
        Room room = roomDAO.getRoomByNumber(roomNumber);
        roomDAO.delete(room);
    }


    public static List<Car> showRoomCars(int roomNumber) {
        return roomDAO.getRoomByNumber(roomNumber).getCars();
    }


    public static Room showCarRoom(String carNumber) {
        return carDAO.getCarByNumber(carNumber).getRoom();
    }

    public static List<Car> showCarsByNumber(String carNumber) {
        return carDAO.getCarsByNumber(carNumber);
    }

    public static List<Car> getAllCars() {
        return carDAO.getCarsList();
    }

    public static Car getCarById(long id) { return carDAO.getCarById(id); }
}
