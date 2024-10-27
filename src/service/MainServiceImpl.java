package service;

import model.Car;
import model.User;
import utils.MyList;

public class MainServiceImpl implements MainService {
    private final CarService carService;
    private final UserService userService;
    private User activeUser;

    public MainServiceImpl(CarService carService, UserService userService) {
        this.carService = carService;
        this.userService = userService;
    }

    @Override
    public void addCar(String model, int year, double price) {
        carService.addCar(model, year, price);
    }

    @Override
    public MyList<Car> getAllCars() {
        return carService.getAllCars();
    }

    @Override
    public MyList<Car> getCarsByModel(String model) {
        return carService.getCarsByModel(model);
    }

    @Override
    public MyList<Car> getFreeCars() {
        return carService.getFreeCars();
    }

    @Override
    public boolean updateCarPrice(int id, double price) {
        Car car = carService.getById(id);
        if (car == null || price < 0) return false;
        car.setPrice(price);
        return true;
    }

    @Override
    public boolean takeCar(int id) {
        Car car = carService.getById(id);
        if (car == null || car.isBusy()) return false;
        car.markAsBusy();
        if (activeUser != null) activeUser.getUserCars().add(car);
        return true;
    }

    @Override
    public Car deleteCar(int id) {
        Car car = carService.getById(id);
        if (car != null) carService.deleteCar(car);
        return car;
    }

    @Override
    public User registerUser(String email, String password) {
        if (userService.isEmailExists(email)) return null;
        return userService.addUser(email, password);
    }

    @Override
    public boolean loginUser(String email, String password) {
        User user = userService.getUserByEmail(email);
        if (user == null || !user.getPassword().equals(password)) return false;
        activeUser = user;
        return true;
    }

    @Override
    public void logout() {
        activeUser = null;
    }
}
