package racinggame.domain.value;

import racinggame.domain.Car;

import java.util.*;
import java.util.stream.Collectors;

public class MoveResult {
    private static final int NOT_FOUNT_MAX = 0;

    private final List<Car> cars;

    public MoveResult(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> results() {
        return Collections.unmodifiableList(cars);
    }

    public List<Car> findWinner() {
        int maxPosition = getMaxPosition();

        return Collections.unmodifiableList(cars.stream()
                .filter(car -> car.compareSamePosition(maxPosition))
                .collect(Collectors.toList()));
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::position)
                .max()
                .orElse(NOT_FOUNT_MAX);
    }
}
