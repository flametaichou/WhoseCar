package ru.flametaichou.whosecar.dao;

import ru.flametaichou.whosecar.model.Car;

import java.util.List;

public interface CarDao {
    public void save(Car c);
    public void delete(Car c);
    public List<Car> getCarsList();
    public Car getCarByNumber(String n);
    public Car getCarById(Long car_id);
}
