package com.racingcar.game;

import com.racingcar.car.Car;

public class GameMaker {
    public static Game make(int gameRound, int numberOfCar) {
        return new Game(gameRound, makeCars(numberOfCar));
    }

    private static Car[] makeCars(int numberOfCar) {
        Car[] cars = new Car[numberOfCar];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car();
        }

        return cars;
    }
}
