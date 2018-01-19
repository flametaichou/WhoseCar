package ru.flametaichou.whosecar.main;

public class Main {
    public static void main(String[] args) {
        RoomsCarsDatabase app = new RoomsCarsDatabase();
        app.createRoom(666);
        app.createCar("Ж123АК","Audi", "black");
        app.createCar("З232ВА","ВАЗ", "red");
        app.addCarToRoomByNumbers(666,"Ж123АК");
        app.addCarToRoomByNumbers(666,"З232ВА");
        app.createRoom(511);
        app.createCar("T342ED","Ford", "blue");
        app.addCarToRoomByNumbers(511,"T342ED");
        app.createRoom(231);
        app.close();
    }
}