package com.next.step.step3.domain;

import java.util.ArrayList;
import java.util.List;

public class MoveResult {

    private final Cars cars;

    public MoveResult(List<Car> cars) {
        List<Car> copyCars = new ArrayList<>();
        for (Car car : cars) {
            copyCars.add(new Car(car.position(), car.name()));
        }
        this.cars = new Cars(copyCars);
    }

    public List<Car> getCarElement() {
        return cars.carElements();
    }
}
