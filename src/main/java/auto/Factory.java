package auto;

import auto.DAO.CarDAO;
import auto.DAO.Impl.CarDAOImpl;
import auto.DAO.Impl.RoomDAOImpl;
import auto.DAO.RoomDAO;

public class Factory {

    private static CarDAO carDAO = null;
    private static RoomDAO roomDAO = null;
    private static Factory instance = null;

    public static synchronized Factory getInstance(){
        if (instance == null){
            instance = new Factory();
        }
        return instance;
    }

    public CarDAO getCarDAO(){
        if (carDAO == null){
            carDAO = new CarDAOImpl();
        }
        return carDAO;
    }

    public RoomDAO getRoomDAO(){
        if (roomDAO == null){
            roomDAO = new RoomDAOImpl();
        }
        return roomDAO;
    }
}
