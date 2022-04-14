package racingcar.domain;

import racingcar.domain.strategy.MoveStrategy;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateDuplicateName(cars);
        this.cars = cars;
    }

    private void validateDuplicateName(List<Car> cars) {
        Set<String> names = cars.stream()
                .map(Car::getName)
                .collect(Collectors.toSet());

        if (names.size() != cars.size()) {
            throw new IllegalArgumentException("cars can't have same names");
        }
    }

    public void move(MoveStrategy strategy) {
        cars.forEach(car -> car.move(strategy));
    }

    public Map<String, Integer> getNameToPosition() {
        return cars.stream()
                .collect(Collectors.toMap(Car::getName, Car::getPosition));
    }

    public List<String> getMostDistantCarNames() {
        Car mostDistantCar = Collections.max(cars);

        return cars.stream()
                .filter(car -> car.compareTo(mostDistantCar) == 0)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
