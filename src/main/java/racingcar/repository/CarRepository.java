package racingcar.repository;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public enum CarRepository {

    INSTANCE;

    private final List<Car> cars = new ArrayList<>();

    public void save(Car car) {
        cars.add(car);
    }

    public List<Car> findAll() {
        return Collections.unmodifiableList(cars);
    }

    public List<Integer> findAllMovementRange() {
        return cars.stream()
                .map(Car::getMovementRange)
                .collect(Collectors.toList());
    }
}
