package com.racingcar.game;

import com.racingcar.car.Car;

import java.util.ArrayList;
import java.util.List;

public class GameMaker {
    public static Game make(int gameRound, int numberOfCar) {
        return new Game(gameRound, makeCars(numberOfCar));
    }

    private static List<Car> makeCars(int numberOfCar) {
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < numberOfCar; i++) {
            cars.add(new Car(i));
        }

        return cars;
    }
}
