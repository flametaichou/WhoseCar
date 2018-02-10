package ru.flametaichou.whosecar.model;

public class CarRoom {

    private String carNumber;
    private int roomNumber;

    public CarRoom() {
        super();
    }

    public CarRoom(String carNumber, int roomNumber) {
        this.carNumber = carNumber;
        this.roomNumber = roomNumber;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
        return "CarRoom{" +
                "carNumber='" + carNumber + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                '}';
    }
}
