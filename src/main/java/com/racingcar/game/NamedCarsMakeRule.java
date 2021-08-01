package com.racingcar.game;

import com.racingcar.car.Car;
import com.racingcar.car.NamedCar;

import java.util.ArrayList;
import java.util.List;

public class NamedCarsMakeRule implements CarsMakeRule {
    @Override
    public List<Car> makeCar(String input) {
        List<Car> cars = new ArrayList<>();
        String[] names = input.split(",");


        for (int i = 0; i < names.length; i++) {
            cars.add(new NamedCar(i, names[i]));
        }

        return cars;
    }
}
