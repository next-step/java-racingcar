package com.jaenyeong.mission2.racingcar.dto;

import com.jaenyeong.mission2.racingcar.domain.Car;
import com.jaenyeong.mission2.racingcar.domain.Cars;

import java.util.List;

public class RacingHistoryDto {
    private final int maxTurn;
    private final List<String> winners;
    private final List<Car> carList;

    public RacingHistoryDto(final int turn, final Cars cars) {
        this.maxTurn = turn;
        this.winners = cars.getWinners();
        carList = setHistory(cars);
    }

    private List<Car> setHistory(final Cars cars) {
        return cars.copyCars();
    }

    public int getMaxTurn() {
        return maxTurn;
    }

    public List<String> getWinners() {
        return winners;
    }

    public List<Car> getCarList() {
        return carList;
    }
}
