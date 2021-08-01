package com.racingcar.game;

import com.racingcar.car.Car;

import java.util.ArrayList;
import java.util.List;

public class NumberOfCarsMakeRule implements MakeCarsRule {
    @Override
    public List<Car> makeCar(String input) {
        int numberOfCar = Integer.parseInt(input);
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < numberOfCar; i++) {
            cars.add(new Car(i));
        }

        return cars;
    }
}
