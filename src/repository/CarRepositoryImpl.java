package repository;

import model.Car;
import utils.MyArrayList;
import utils.MyList;

import java.util.concurrent.atomic.AtomicInteger;

public class CarRepositoryImpl implements CarRepository {
    private final MyList<Car> cars;
    private final AtomicInteger currentId = new AtomicInteger(4);

    public CarRepositoryImpl() {
        this.cars = initCars();
    }

    private MyList<Car> initCars() {
        MyList<Car> cars = new MyArrayList<>();
        cars.add(new Car(1, "BMW", 2022, 50));
        cars.add(new Car(2, "AUDI", 2023, 55));
        cars.add(new Car(3, "MERCEDES", 2024, 60));
        return cars;
    }

    @Override
    public void addCar(String model, int year, double price) {
        Car car = new Car(currentId.getAndIncrement(), model, year, price);
        cars.add(car);
    }

    @Override
    public MyList<Car> getAllCars() {
        return cars;
    }

    @Override
    public Car getById(int id) {
        for (Car car : cars) {
            if (car.getId() == id) return car;
        }
        return null;
    }

    @Override
    public MyList<Car> getCarsByModel(String model) {
        MyList<Car> result = new MyArrayList<>();
        for (Car car : cars) {
            if (car.getModel().equals(model)) result.add(car);
        }
        return result;
    }

    @Override
    public MyList<Car> getFreeCars() {
        MyList<Car> result = new MyArrayList<>();
        for (Car car : cars) {
            if (!car.isBusy()) result.add(car);
        }
        return result;
    }

    @Override
    public void deleteCar(Car car) {
        cars.remove(car);
    }
}
