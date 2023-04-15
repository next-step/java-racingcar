package io;

import domain.Car;

import java.util.List;

public class ResultView {
    public static String getGameAsString(List<Car> cars) {
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
