package com.jaenyeong.mission2.racingcar.domain;

import java.util.List;

public class Car {
    private Distance dist;
    private final RacingHistory history;

    public Car() {
        this.dist = new Distance();
        this.history = new RacingHistory();
    }

    public void move() {
        dist = dist.move();

        history.writeRaceDistanceHistory(dist.getDist());
    }

    public int getCurrentDistance() {
        return dist.getDist();
    }

    public List<Integer> getRacingHistory() {
        return history.getDistanceForAllTurn();
    }
}
