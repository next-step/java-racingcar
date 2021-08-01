package com.racingcar.game;

import com.racingcar.car.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class GameResult<T extends Car> {
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
        cars.addAll(carList);
    }

    public void addAllWinners(List<T> winnerList) {
        winners.addAll(winnerList);
    }

    public T getCar(int id) {
        return cars.stream().filter((car) -> car.getId() == id).findFirst()
                .orElseThrow(() -> new NoSuchElementException("this car doesn't exist, car id : " + id));
    }

    public List<T> getWinners() {
        return new ArrayList<>(winners);
    }
}
