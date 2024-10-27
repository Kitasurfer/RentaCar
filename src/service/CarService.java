package service;/* Group: 52-1, "AIT Hi-tech team" GMBH 
Author: Bogdan Fesenko
Date: 27-10-2024
*/

import model.Car;
import utils.MyList;

/*

 */
public interface CarService {


    void deleteCar(Car car);

    Car getById(int id);

    MyList<Car> getFreeCars();

    MyList<Car> getCarsByModel(String model);

    MyList<Car> getAllCars();

    void addCar(String model, int year, double price);
}
