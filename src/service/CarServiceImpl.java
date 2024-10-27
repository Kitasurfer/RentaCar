package service;/* Group: 52-1, "AIT Hi-tech team" GMBH 
Author: Bogdan Fesenko
Date: 27-10-2024
*/

import model.Car;
import repository.CarRepository;
import utils.MyList;

/*

 */
public class CarServiceImpl implements CarService{

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    // TODO: only ADMIN
    @Override
    public void deleteCar(Car car) {
        carRepository.deleteCar(car);
    }

    @Override
    public Car getById(int id) {
        return carRepository.getById(id);
    }

    @Override
    public MyList<Car> getFreeCars() {
        return carRepository.getFreeCars();
    }

    @Override
    public MyList<Car> getCarsByModel(String model) {
        return carRepository.getCarsByModel(model);
    }

    @Override
    public MyList<Car> getAllCars() {
        return carRepository.getAllCars();
    }

    // TODO: only ADMIN
    @Override
    public void addCar(String model, int year, double price) {
        carRepository.addCar(model, year, price);
    }
}
