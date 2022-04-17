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
        Set<CarName> names = cars.stream()
                .map(Car::getName)
                .collect(Collectors.toSet());
        if (cars.size() != names.size()) {
            throw new IllegalArgumentException("cars can't have same name");
        }
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
