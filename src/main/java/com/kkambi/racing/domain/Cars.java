package com.kkambi.racing.domain;

import com.kkambi.racing.strategy.MovingStrategy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car>cars) {
        this.cars = cars;
    }

    public void tryToMoveCars(MovingStrategy movingStrategy) {
        for (Car car : cars) {
            car.move(movingStrategy);
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public Winners chooseWinners() {
        Car maxLocationCar = Collections.max(cars);
        return new Winners(cars.stream()
                .filter(car -> car.equals(maxLocationCar))
                .collect(Collectors.toList()));
    }
}
