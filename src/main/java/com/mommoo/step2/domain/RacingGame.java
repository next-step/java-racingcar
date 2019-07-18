package com.mommoo.step2.domain;

import com.mommoo.step2.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private static final int INIT_POSITION = 0;
    private final List<Car> cars;

    public RacingGame(String[] carNames) {
        this.cars = convertToCarList(carNames);
    }

    private List<Car> convertToCarList(String[] carNames) {
        return Arrays.stream(carNames)
                     .map(carName -> new Car(carName, INIT_POSITION))
                     .collect(Collectors.toList());
    }

    public List<Car> move() {
        List<Car> nextCars = cars.stream()
                                 .map(Car::nextCar)
                                 .collect(Collectors.toList());

        cars.clear();
        cars.addAll(nextCars);

        return nextCars;
    }
}
