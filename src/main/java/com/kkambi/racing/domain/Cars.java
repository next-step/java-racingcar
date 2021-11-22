package com.kkambi.racing.domain;

import java.util.Collections;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car>cars) {
        this.cars = cars;
    }

    public void tryToMoveCars() {
        for (Car car : cars) {
            car.move();
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
