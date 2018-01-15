package auto.logic;

public class Car {
    private int id;
    private String number;
    private String brand;
    private String color;
    private int room_id;

    public Car () {

    }

    public void setId (int id) {
        this .id = id;
    }

    public int getId () {
        return id;
    }

    public int getRoom_id () {
        return room_id;
    }

    public void setRoom_id (int room_id) {
        this.room_id = room_id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
