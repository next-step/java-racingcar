package com.jaenyeong.mission2.racingcar.dto;

import com.jaenyeong.mission2.racingcar.domain.Cars;

import java.util.List;

public class RacingHistoryDto {
    private final List<List<Integer>> racingHistory;

    public RacingHistoryDto(final Cars cars) {
        this.racingHistory = cars.getRaceHistoriesForAllCars();
    }
}
