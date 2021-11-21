package com.kkambi.racing.domain;

import com.kkambi.racing.util.Dice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
