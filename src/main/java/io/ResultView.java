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

    public String getGameAsString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : cars) {
            stringBuilder.append(getCarAsString(car));
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public static String getCarAsString(Car car) {
        return car.getOwner() + " : " + "-".repeat(Math.max(0, car.getDistance()));
    }
}
