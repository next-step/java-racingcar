package com.racingcar.game;

import com.racingcar.car.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameResult <T extends Car> {
    List<RoundResult> roundResults = new ArrayList<>();
    List<T> cars = new ArrayList<>();
    List<T> winners = new ArrayList<>();

    public void addRoundResult(RoundResult roundResult) {
        roundResults.add(roundResult);
    }

    public int getRoundSize() {
        return roundResults.size();
    }

    public RoundResult getRoundResult(int roundIndex) {
        return roundResults.get(roundIndex);
    }

    public void addAllCars(List<T> carList) {
        carList.stream().forEach((car) -> this.cars.add(car));
    }

    public List<Integer> getCarIdList() {
        return cars.stream().map((car) -> car.getId()).collect(Collectors.toList());
    }

    public void addAllWinners(List<T> winnerList) {
        winnerList.stream().forEach((winner) -> this.winners.add(winner));
    }
}
