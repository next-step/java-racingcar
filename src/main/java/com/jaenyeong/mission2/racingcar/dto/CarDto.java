package com.jaenyeong.mission2.racingcar.dto;

import com.jaenyeong.mission2.racingcar.domain.Car;

import java.util.List;

public class CarDto {
    private final String name;
    private final List<Integer> history;

    public CarDto(final Car car) {
        this.name = car.getName();
        this.history = car.getRacingHistory();
    }

    public int getDistanceByTurn(final int turn) {
        return history.get(turn - 1);
    }

    public String getName() {
        return name;
    }
}
