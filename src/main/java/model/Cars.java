package model;

import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars (List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> stepForward () {
        cars.forEach(car -> car.stepForward(new RandomMovingStrategy()));
        return cars;
    }

    public void printCars () {
        cars.forEach(Car::printCar);
    }
}
