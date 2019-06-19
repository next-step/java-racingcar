package com.java.jaeheon.step2;

import java.util.ArrayList;
import java.util.List;

public class CarManagement {
    private final List<Car> cars;

    public CarManagement() {
        this.cars = new ArrayList<>();
    }

    public List<Car> Cars() {
        return cars;
    }

    public CarManagement register() {
        Car car = new Car();
        cars.add(car);
        return this;
    }

    public CarManagement registerByNumber(int numberOfCars) {
        for (int i = 0; i < numberOfCars; i++) {
            register();
        }
        return this;
    }

    public long numberOfRegisteredCars() {
        return cars.stream().count();
    }

}
