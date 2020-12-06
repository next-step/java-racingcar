package com.jaenyeong.mission2.racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingHistory {
    public static final int STOP = 0;
    private int currentTurn;
    private final List<RaceByTurn> history;

    public RacingHistory() {
        this.history = new ArrayList<>();
        this.currentTurn = STOP;
    }

    public void writeRaceDistanceHistory(final int dist) {
        history.add(new RaceByTurn(++currentTurn, dist));
    }

    public int getRaceHistoryForTurn(final int turn) {
        return getRaceHistory(turn);
    }

    public int getRaceHistoryForCurrentTurn() {
        if (currentTurn <= STOP) {
            return STOP;
        }

        return getRaceHistory(this.currentTurn);
    }

    private int getRaceHistory(final int turn) {
        return history.get(turn - 1).getDistance();
    }

    public List<Integer> getDistanceForAllTurn() {
        return history.stream()
            .map(RaceByTurn::getDistance)
            .collect(Collectors.toList());
    }

    public int getCurrentTurn() {
        return currentTurn;
    }
}
