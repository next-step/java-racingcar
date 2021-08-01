package com.racingcar.game;

import com.racingcar.car.Car;
import com.racingcar.dice.Dice;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

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
        gameResult.addAllWinners(decideWinners(cars));
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

    private List<Car> decideWinners(List<T> cars) {
        int max = cars.stream().mapToInt((car) -> car.getDistance()).max().orElseThrow(() -> new NoSuchElementException("can not find max distance"));

        return cars.stream().filter((car) -> car.getDistance() == max).collect(Collectors.toList());
    }
}
