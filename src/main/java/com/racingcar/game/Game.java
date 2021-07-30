package com.racingcar.game;

import com.racingcar.car.Car;
import com.racingcar.dice.Dice;

import java.util.Arrays;

public class Game {
    private int currentRound;
    private final int gameRound;
    private Car[] cars;

    public Game(int gameRound, Car[] cars) {
        this.gameRound = gameRound;
        this.cars = cars;
    }

    public int[][] play() {
        int[][] result = new int[gameRound][cars.length];
        currentRound = 0;

        while (currentRound < gameRound) {
            playOneRound();
            result[currentRound++] = getRoundResult();
        }

        return result;
    }

    private void playOneRound() {
        for (Car car : this.cars) {
            car.move(Dice.getNumber());
        }
    }

    private int[] getRoundResult() {
        return Arrays.stream(cars)
                .mapToInt(car -> car.getDistance())
                .toArray();
    }


}
