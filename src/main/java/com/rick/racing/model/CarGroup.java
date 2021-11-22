package com.rick.racing.model;

import com.rick.racing.controller.CarMovingStrategy;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CarGroup {

    private final List<Car> cars;

    private CarGroup(final List<Car> cars) {
        this.cars = cars;
    }

    public static CarGroup create(final List<Car> cars) {
        return new CarGroup(cars);
    }

    public void doRound(final CarMovingStrategy carMovingStrategy) {
        for (Car car : cars) {
            car.move(carMovingStrategy);
        }
    }

    public List<Car> getWinners() {
        Optional<Car> optionalWinnerCar = cars.stream()
            .max(Comparator.comparing(Car::getPosition));

        if (!optionalWinnerCar.isPresent()) {
            return Collections.emptyList();
        }

        final Car winner = optionalWinnerCar.get();

        return cars.stream()
            .filter(car -> car.isPositionAt(winner))
            .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }
}
