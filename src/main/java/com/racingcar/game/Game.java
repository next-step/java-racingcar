package com.racingcar.game;

import com.racingcar.car.Car;
import com.racingcar.dice.Dice;
import com.racingcar.game.result.RoundCarRecord;
import com.racingcar.view.GameDrawer;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Game {
    private int currentRound;
    private final int gameRound;
    private List<Car> cars;

    public Game(int gameRound, List<Car> cars) {
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
            car.move(Dice.getNumber());
            roundRecords.add(RoundCarRecord.of(car));
        }

        return roundRecords;
    }

    private int[] getRoundResult() {
        return Arrays.stream(cars)
                .mapToInt(car -> car.getDistance())
                .toArray();
    }
}
