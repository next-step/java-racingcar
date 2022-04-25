package racing.controller;

import racing.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class RacingWinner {

    public List<Car> getWinnerList(List<Car> cars) {
        int maxDistance = getMaxDistance(cars);
        return createWinnerList(cars, maxDistance);
    }

    private int getMaxDistance(List<Car> cars) {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow()
                .getDistance();
    }

    private List<Car> createWinnerList(List<Car> cars, int maxDistance) {
        return cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .collect(Collectors.toList());
    }

}
