package cars.whosecar.model;
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
    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private List<Car> cars;

    public Room() {
        super();
    }
    public Room(int roomNumber, List<Car> phone) {
        this.roomNumber = roomNumber;
        this.cars = phone;
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
                ", cars=" + cars +
                '}';
    }
}