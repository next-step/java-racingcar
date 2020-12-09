package com.jaenyeong.mission2.racingcar.dto;

import com.jaenyeong.mission2.racingcar.domain.Car;
import com.jaenyeong.mission2.racingcar.domain.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class RacingHistoryDto {
    private final int maxTurn;
    private final List<String> winners;
    private final List<CarDto> history;

    public RacingHistoryDto(final int turn, final Cars cars) {
        this.maxTurn = turn;
        this.winners = cars.getWinners();

        history = setHistory(cars);
    }

    private List<CarDto> setHistory(final Cars cars) {
        final List<Car> copy = cars.copyCars();
        return copy.stream()
            .map(CarDto::new)
            .collect(Collectors.toList());
    }

    public int getMaxTurn() {
        return maxTurn;
    }

    public List<String> getWinners() {
        return winners;
    }

    public List<CarDto> getHistory() {
        return history;
    }
}
