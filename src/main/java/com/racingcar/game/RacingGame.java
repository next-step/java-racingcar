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

    public List<RoundCarRecord> playOneRound() {
        if (isGameFinished()) {
            throw new IllegalStateException("Game is already finished");
        }

        currentRound++;
        List<RoundCarRecord> roundRecords = new ArrayList<>();

        for (Car car : this.cars) {
            RoundCarRecord roundCarRecord = car.move(Dice.getNumber());
            roundRecords.add(roundCarRecord);
        }

        return roundRecords;
    }

    public boolean isGameFinished() {
        return currentRound >= gameRound;
    }

    public boolean isNotGameFinished() {
        return !isGameFinished();
    }

    public List<Car> getWinners() {
        if (isNotGameFinished()) {
            throw new IllegalStateException("Can not get winners because Game is not finished");
        }

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
