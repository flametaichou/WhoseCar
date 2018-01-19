package ru.flametaichou.whosecar.main;

import ru.flametaichou.whosecar.model.Car;
import ru.flametaichou.whosecar.model.Room;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        RoomsCarsDatabase app = new RoomsCarsDatabase();
        /*
        app.createRoom(666);
        app.createCar("Ж123АК","Audi", "black");
        app.createCar("З232ВА","ВАЗ", "red");
        app.addCarToRoomByNumbers(666,"Ж123АК");
        app.addCarToRoomByNumbers(666,"З232ВА");
        app.createRoom(511);
        app.createCar("T342ED","Ford", "blue");
        app.addCarToRoomByNumbers(511,"T342ED");
        app.createRoom(231);
        */
        System.out.println("Cars for room 666:");
        List<Car> list = app.showRoomCars(666);
        for(Car c : list){
            System.out.println("Car:"+c);
        }

        System.out.println("Room for car T342ED:" + app.showCarRoom("Ж123АК"));

        app.close();
    }
}