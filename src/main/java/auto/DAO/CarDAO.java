package auto.DAO;

import auto.logic.Car;
import auto.logic.Room;

import java.util.Collection;
import java.sql.SQLException;

public interface CarDAO {

    public void addCar (Car car) throws SQLException;
    public void updateCar (Long car_id, Car car) throws SQLException;
    public Car getCarBuId (Long car_id) throws SQLException;
    public Collection getAllCars() throws SQLException;
    public void deleteCar (Car car) throws SQLException;
    public Collection getCarsByRoom (Room room) throws SQLException;

}
