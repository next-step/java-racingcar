package com.mommoo.step2.domain;

import com.mommoo.step2.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private static final int INIT_POSITION = 0;
    private List<Car> cars;

    public RacingGame(String[] carNames) {
        this.cars = convertToCars(carNames);
    }

    private List<Car> convertToCars(String[] carNames) {
        return Arrays.stream(carNames)
                     .map(carName -> new Car(carName, INIT_POSITION))
                     .collect(Collectors.toList());
    }

    public List<Car> move() {
        List<Car> nextCars = cars.stream()
                                 .map(car -> car.nextCar(new CarMovingConditioner()))
                                 .collect(Collectors.toList());

        cars = nextCars;
        return nextCars;
    }
}
