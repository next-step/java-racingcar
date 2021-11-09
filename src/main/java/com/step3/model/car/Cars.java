package com.step3.model.car;

import java.util.LinkedList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(int carCount) {
        List<Car> cars = new LinkedList<>();

        for (int idx = 0; idx < carCount; idx++) {
            cars.add(new Car(new CarId(idx), new CarPosition(0)));
        }

        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }
}