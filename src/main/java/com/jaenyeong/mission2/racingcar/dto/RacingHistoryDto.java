package com.jaenyeong.mission2.racingcar.dto;

import com.jaenyeong.mission2.racingcar.domain.Cars;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingHistoryDto {
    private final int maxTurn;
    private final Map<String, List<Integer>> history;

    public RacingHistoryDto(final int turn, final Cars cars) {
        this.maxTurn = turn;
        this.history = cars.getRaceHistoriesForAllCars();
    }

    public Map<Integer, Map<String, Integer>> parsePrintFormat() {
        final Map<Integer, Map<String, Integer>> printHistory = new HashMap<>();

        for (int turn = 0; turn < maxTurn; turn++) {
            getHistoryOfCarByThisTurn(printHistory, turn);
        }

        return printHistory;
    }

    private void getHistoryOfCarByThisTurn(final Map<Integer, Map<String, Integer>> printHistory, final int turn) {
        final Map<String, Integer> distOfTurn = new HashMap<>();

        for (Map.Entry<String, List<Integer>> car : history.entrySet()) {
            distOfTurn.put(car.getKey(), car.getValue().get(turn));
        }

        printHistory.put(turn, distOfTurn);
    }
}
