package io;

import domain.Car;

import java.util.List;

public class ResultView {
    private final List<Car> cars;

    public ResultView(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }
}
