package racing.controller;

import racing.domain.Car;
import racing.domain.Position;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingWinner {

    public List<Car> getWinnerList(List<Car> cars) {
        Position maxPosition = getMaxPosition(cars);
        return createWinnerList(cars, maxPosition);
    }

    private Position getMaxPosition(List<Car> cars) {
        return cars.stream()
                .max(Comparator.comparing(Car::getPosition))
                .orElseThrow()
                .getPosition();
    }

    private List<Car> createWinnerList(List<Car> cars, Position maxPosition) {
        return cars.stream()
                .filter(car -> car.isWinner(maxPosition))
                .collect(Collectors.toList());
    }

}
