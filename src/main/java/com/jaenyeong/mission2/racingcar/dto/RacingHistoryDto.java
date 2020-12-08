package com.jaenyeong.mission2.racingcar.dto;

import com.jaenyeong.mission2.racingcar.domain.Cars;

import java.util.ArrayList;
import java.util.List;

public class RacingHistoryDto {
    private final int maxTurn;
    private final List<List<Integer>> racingHistory;

    public RacingHistoryDto(final int turn, final Cars cars) {
        this.maxTurn = turn;
        this.racingHistory = cars.getRaceHistoriesForAllCars();
    }

    public List<List<Integer>> getRacingHistory() {
        return racingHistory;
    }

    public List<List<Integer>> parsingRacingHistoryToPrintFormat() {
        final List<List<Integer>> parseHistories = new ArrayList<>();

        for (int turn = 0; turn < maxTurn; turn++) {
            parseHistories.add(getRacingHistoriesForTurn(turn));
        }

        return parseHistories;
    }

    private List<Integer> getRacingHistoriesForTurn(final int turn) {
        final List<Integer> historyForTurn = new ArrayList<>();
        for (List<Integer> car : racingHistory) {
            historyForTurn.add(car.get(turn));
        }

        return historyForTurn;
    }
}
