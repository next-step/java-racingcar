package model;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class WinnerCars {

    private WinnerCars() {

    }

    public static List<Car> getWinnerCars(List<Car> cars) {
        Position winnerPosition = getWinnerPosition(cars);
        return cars.stream()
                .filter(car -> car.equalPosition(winnerPosition.getPosition()))
                .collect(Collectors.toList());
    }

    private static Position getWinnerPosition(List<Car> cars) {
        return Collections.max(cars, Comparator.comparing(Car::getPosition)).getPosition();
    }
}
