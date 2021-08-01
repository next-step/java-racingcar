package com.racingcar.game;

import com.racingcar.car.Car;
import com.racingcar.dice.Dice;

import java.util.List;

public class Game <T extends Car> {
    private int currentRound;
    private final int gameRound;
    private List<T> cars;

    public Game(int gameRound, List<T> cars) {
        this.gameRound = gameRound;
        this.cars = cars;
    }

    public GameResult play() {
        GameResult gameResult = new GameResult();

        this.currentRound = 0;
        while (currentRound < gameRound) {
            playOneRound();
            gameResult.addRoundResult(getRoundResult(cars));
            currentRound++;
        }

        gameResult.addAllCars(cars);
        return gameResult;
    }

    private void playOneRound() {
        for (Car car : this.cars) {
            car.move(Dice.getNumber());
        }
    }

    private RoundResult getRoundResult(List<T> cars) {
        RoundResult result = new RoundResult();
        cars.forEach((car) -> {
            result.add(car);
        });
        return result;
    }
}
