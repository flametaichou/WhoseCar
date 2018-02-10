package ru.flametaichou.whosecar.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="ROOMS")
public class Room {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private int roomNumber;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "room")
    @JsonIgnoreProperties("room")
    private List<Car> cars;

    public Room() {
        super();
    }

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Room(int roomNumber, List<Car> cars) {
        this.roomNumber = roomNumber;
        this.cars = cars;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getRoomNumber() {
        return roomNumber;
    }
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
    public List<Car> getCars() {
        return cars;
    }
    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", roomNumber='" + roomNumber + '\'' +
                '}';
    }
}