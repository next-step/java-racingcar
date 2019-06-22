package com.java.jaeheon.step2.domain;

import java.util.List;

public class CarManagement {
    private final List<Car> cars;

    public CarManagement(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

}
