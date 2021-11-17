package com.kkambi.racing.domain;

import com.kkambi.racing.util.Dice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(0, carName));
        }
        this.cars = cars;
    }

    public void tryToMoveCars() {
        for (Car car : cars) {
            car.tryToMove(Dice.roll(10));
        }
    }

    public List<Car> chooseWinners() {
        Car maxLocationCar = Collections.max(cars, Comparator.comparing(Car::getLocation));
        return cars.stream()
                .filter(car -> car.getLocation().equals(maxLocationCar.getLocation()))
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
