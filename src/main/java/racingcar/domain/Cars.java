package racingcar.domain;

import racingcar.domain.strategy.MoveStrategy;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> names) {
        validateDuplicateName(names);
        this.cars = createCars(names);
    }

    private void validateDuplicateName(List<String> names) {
        Set<String> namesSet = new HashSet<>(names);
        if (names.size() != namesSet.size()) {
            throw new IllegalArgumentException("cars can't have same name");
        }
    }

    private List<Car> createCars(List<String> names) {
        return names.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void move(MoveStrategy strategy) {
        cars.forEach(car -> car.move(strategy));
    }

    public Map<CarName, Position> getCurrentPositions() {
        return cars.stream()
                .collect(Collectors.toMap(Car::getName, Car::getPosition));
    }

    public List<Car> getMostDistantCars() {
        Car mostDistantCar = Collections.max(cars);

        return cars.stream()
                .filter(car -> car.compareTo(mostDistantCar) == 0)
                .collect(Collectors.toList());
    }
}
