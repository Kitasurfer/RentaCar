package service;

import model.Car;
import model.User;
import utils.MyList;

public interface MainService {
    void addCar(String model, int year, double price);
    MyList<Car> getAllCars();
    MyList<Car> getCarsByModel(String model);
    MyList<Car> getFreeCars();
    boolean updateCarPrice(int id, double price);
    boolean takeCar(int id);
    Car deleteCar(int id);
    User registerUser(String email, String password);
    boolean loginUser(String email, String password);
    void logout();
}
