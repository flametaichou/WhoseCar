package ru.flametaichou.whosecar.controller;
 
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import ru.flametaichou.whosecar.main.DatabaseController;
import ru.flametaichou.whosecar.model.Car;
import ru.flametaichou.whosecar.model.CarRoom;
import ru.flametaichou.whosecar.model.Room;

@RestController
public class WebAppRestController {
 
    //@Autowired ?

    DatabaseController app = new DatabaseController(); //Сервис который манипулирует данными

    @RequestMapping(value = "/rest/", method = RequestMethod.GET)
    public ResponseEntity<List<Car>> listAllCars() {
        List<Car> cars = app.getAllCars();
        if (cars.isEmpty()) {
            return new ResponseEntity<List<Car>>(HttpStatus.NO_CONTENT);//Можно заюзать HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Car>>(cars, HttpStatus.OK);
    }

    @RequestMapping(value = "/rest/carnumber/", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Car>> listCarsByNumber(@RequestBody String number) {
        System.out.println(number);
        List<Car> cars = new ArrayList<Car>();
        cars = app.showCarsByNumber(number);
        if (cars.isEmpty()) {
            return new ResponseEntity<List<Car>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Car>>(cars, HttpStatus.OK);
    }

    @RequestMapping(value = "/rest/roomnumber/", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Car>> listCarsByRoomNumber(@RequestBody String numberString) {
        int number = Integer.parseInt(numberString);
        System.out.println(number);
        List<Car> cars = new ArrayList<Car>();
        cars = app.showRoomCars(number);
        if (cars.isEmpty()) {
            return new ResponseEntity<List<Car>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Car>>(cars, HttpStatus.OK);
    }

    @RequestMapping(value = "/rest/addcar/", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addCar(@RequestBody Car data) {
        System.out.println(data);
        app.createCar(data.getCarNumber(),data.getCarBrand(),data.getCarColor());
        /*if () {
            return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
        }*/
        return new ResponseEntity<String>("OK", HttpStatus.OK);
    }

    @RequestMapping(value = "/rest/addroom/", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addRoom(@RequestBody Room data) {
        System.out.println(data);
        app.createRoom(data.getRoomNumber());
        /*if () {
            return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
        }*/
        return new ResponseEntity<String>("OK", HttpStatus.OK);
    }

    @RequestMapping(value = "/rest/bind/", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> bindCarRoom(@RequestBody CarRoom data) {
        System.out.println(data);
        app.addCarToRoomByNumbers(data.getRoomNumber(), data.getCarNumber());
        /*if () {
            return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
        }*/
        return new ResponseEntity<String>("OK", HttpStatus.OK);
    }

    @RequestMapping(value = "/rest/unbind/", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> unbindCarRoom(@RequestBody CarRoom data) {
        System.out.println("unbind" + data.getRoomNumber() + " " + data.getCarNumber());
        app.removeCarFromRoom(data.getRoomNumber(), data.getCarNumber());
        /*if () {
            return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
        }*/
        return new ResponseEntity<String>("OK", HttpStatus.OK);
    }

    @RequestMapping(value = "/rest/deletecar/", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteCar(@RequestBody String data) {
        System.out.println(data);
        app.deleteCarByNumber(data);
        /*if () {
            return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
        }*/
        return new ResponseEntity<String>("OK", HttpStatus.OK);
    }

    @RequestMapping(value = "/rest/deleteroom/", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteRoom(@RequestBody int data) {
        System.out.println(data);
        app.deleteRoomByNumber(data);
        /*if () {
            return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
        }*/
        return new ResponseEntity<String>("OK", HttpStatus.OK);
    }

}