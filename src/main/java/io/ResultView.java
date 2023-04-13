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

    public void printAll() {
        for (Car car : cars) {
            System.out.println(printCarDistance(car));
        }
    }

    public static String printCarDistance(Car car) {
        return "-".repeat(Math.max(0, car.getDistance()));
    }
}
