package com.racingcar.game;

import com.racingcar.car.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameResult {
    List<RoundResult> roundResults = new ArrayList<>();
    List<Car> cars = new ArrayList<>();

    public void addRoundResult(RoundResult roundResult) {
        roundResults.add(roundResult);
    }

    public int getRoundSize() {
        return roundResults.size();
    }

    public RoundResult getRoundResult(int roundIndex) {
        return roundResults.get(roundIndex);
    }

    public void addAllCars(List<Car> carList) {
        carList.stream().forEach((car) -> this.cars.add(car));
    }

    public List<Integer> getCarIdList() {
        return cars.stream().map((car) -> car.getId()).collect(Collectors.toList());
    }
}
