package com.racingcar.game;

import com.racingcar.game.car.Car;
import com.racingcar.dice.Dice;
import com.racingcar.game.result.RoundCarRecord;
import com.racingcar.view.GameDrawer;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class RacingGame {
    private int currentRound;
    private final int gameRound;
    private List<Car> cars;

    public RacingGame(int gameRound, List<Car> cars) {
        this.gameRound = gameRound;
        this.cars = cars;
    }

    public void play() {
        GameDrawer.drawGameStart();

        while (currentRound < gameRound) {
            GameDrawer.drawOneRound(playOneRound());
            currentRound++;
        }

        GameDrawer.drawWinners(decideWinners());
    }

    private List<RoundCarRecord> playOneRound() {
        List<RoundCarRecord> roundRecords = new ArrayList<>();

        for (Car car : this.cars) {
            RoundCarRecord roundCarRecord = car.move(Dice.getNumber());
            roundRecords.add(roundCarRecord);
        }

        return roundRecords;
    }

    private List<Car> decideWinners() {
        int max = gameWinnerDistance();

        return cars.stream()
                .filter((car) -> car.isWinner(max))
                .collect(Collectors.toList());
    }

    private int gameWinnerDistance() {
        return this.cars.stream()
                .mapToInt((car) -> car.getDistance()
                ).max()
                .orElseThrow(() -> new NoSuchElementException("can not find max distance"));
    }
}
