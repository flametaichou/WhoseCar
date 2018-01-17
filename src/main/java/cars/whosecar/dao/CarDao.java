package cars.whosecar.dao;

import cars.whosecar.model.Car;

import java.util.List;

public interface CarDao {
    public void save(Car c);
    public List<Car> getCarsList();
    public List<Car> getCarsByNumber(String n);
    public Car getCarById(Long car_id);
}
