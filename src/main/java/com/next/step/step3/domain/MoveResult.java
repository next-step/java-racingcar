package com.next.step.step3.domain;

import java.util.ArrayList;
import java.util.List;

public class MoveResult {

    private final List<Car> carElement;

    public MoveResult(List<Car> cars) {
        this.carElement = new ArrayList<>();
        for (Car car : cars) {
            this.carElement.add(new Car(car.position(), car.name()));
        }
    }

    public List<Car> getCarElement() {
        return carElement;
    }
}
