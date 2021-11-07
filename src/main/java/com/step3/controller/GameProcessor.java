package com.step3.controller;

import com.step3.model.Car;
import com.step3.model.NumberSet;
import com.step3.util.RandomUtil;
import com.step3.view.ResultView;

import java.util.LinkedList;
import java.util.List;

public class GameProcessor {
    public List<Car> getMovedCars(NumberSet myNumber) {
        List<Car> cars = new LinkedList<>();

        for (int idx = 0; idx < myNumber.getCarCount(); idx++) {
            cars.add(new Car(idx, 0));
        }

        for (int attempt = 0; attempt < myNumber.getAttemptCount(); attempt++) {
            ResultView.showResults(move(cars), attempt);
        }

        return cars;
    }

    public List<Car> move(List<Car> cars) {
        for (Car car : cars) {
            car.move(RandomUtil.getRandomValue());
        }

        return cars;
    }
}
