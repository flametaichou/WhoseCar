package cars.whosecar.main;
import cars.whosecar.dao.CarDao;
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

        Car car = new Car("Ж999ШШ");
        roomDAO.addCar(531,car);

        List<Room> list = roomDAO.getRoomsList();
        for(Room p : list){
            System.out.println("Room List::"+p);
        }

        //close
        context.close();
    }
}