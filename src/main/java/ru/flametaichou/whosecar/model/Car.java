package ru.flametaichou.whosecar.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CARS")
public class Car {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String carNumber;
    private String carBrand;
    private String carColor;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    @JsonIgnoreProperties("cars")
    private Room room;

    public Car() {
        super();
    }

    public Car(String carNumber, String carBrand, String carColor) {
        this.carNumber = carNumber;
        this.carBrand = carBrand;
        this.carColor = carColor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", carNumber='" + carNumber + '\'' +
                ", carBrand='" + carBrand + '\'' +
                ", carColor='" + carColor + '\'' +
                '}';
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}