package cars.whosecar.main;
import cars.whosecar.dao.RoomDao;
import cars.whosecar.model.Room;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import cars.whosecar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/beans.xml");
        RoomDao roomDAO = context.getBean(RoomDao.class);
        ArrayList<Car> carArrayList = new ArrayList<Car>();
        carArrayList.add(new Car("Е267МВ"));
        carArrayList.add(new Car("А342ГД"));
        Room room = new Room(531, carArrayList);
        roomDAO.save(room);
        System.out.println("Room::"+ room);
        List<Room> list = roomDAO.getPersonList();
        for(Room p : list){
            System.out.println("Room List::"+p);
        }
        //close resources
        context.close();
    }
}