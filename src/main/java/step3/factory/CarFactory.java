package step3.factory;

import step3.car.Car;

import java.util.List;

public interface CarFactory<T extends Car> {
    Car createCar();
    List<Car> createCars(Integer number);
}
