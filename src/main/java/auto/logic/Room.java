package auto.logic;

import java.util.HashSet;
import java.util.Set;

public class Room {

    private int id;
    private int number;
    private Set cars = new HashSet();


    public Room () {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setCars(Set cars) {
        this.cars = cars;
    }

    public Set getCars() {
        return cars;
    }
}
