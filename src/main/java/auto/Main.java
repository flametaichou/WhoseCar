package auto;

import auto.logic.Car;
import auto.logic.Room;

import java.sql.SQLException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws SQLException {


        System.out.println("test");
        Car car1 = new Car();
        car1.setRoom_id(1);
        car1.setNumber("Э564ЖЧ");
        car1.setBrand("Toyota");
        car1.setColor("grey");
        Car car2 = new Car();
        car2.setNumber("О231ФЦ");
        car2.setBrand("KIA");
        car2.setColor("white");
        Room room1 = new Room();
        room1.setNumber(531);
        Set room1_cars = new HashSet<Car>();
        room1_cars.add(car1);
        room1_cars.add(car2);
        room1.setCars(room1_cars);

        Room room2 = new Room();
        room2.setNumber(467);

        Set room2_cars = new HashSet<Car>();
        room2_cars.add(car1);
        room2_cars.add(car2);
        room2.setCars(room2_cars);


        Factory.getInstance().getCarDAO().addCar(car1);
        Factory.getInstance().getCarDAO().addCar(car2);
        Factory.getInstance().getRoomDAO().addRoom(room1);
        Factory.getInstance().getRoomDAO().addRoom(room2);

        Collection rooms = Factory.getInstance().getRoomDAO().getAllRooms();
        Iterator iterator = rooms.iterator();
        System.out.println("========Все машины=========");
        /*
        while (iterator.hasNext()) {
            Car car = (Car) iterator.next();
            System.out.println("Машина № " + car.getNumber());
        }
        */
        while (iterator.hasNext()) {
            Room room = (Room) iterator.next();
            Collection cars = Factory.getInstance().getCarDAO().getCarsByRoom(room);
            Iterator iterator2 = cars.iterator();
            System.out.println("Комната № " + room.getNumber());
            while (iterator2.hasNext()) {
                Car car = (Car) iterator2.next();
                System.out.println("Машина  № " + car.getNumber());

            }
        }

    }
}
