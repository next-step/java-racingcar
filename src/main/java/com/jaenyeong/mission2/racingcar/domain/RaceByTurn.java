package com.jaenyeong.mission2.racingcar.domain;

public class RaceByTurn {
    private final int turn;
    private final int distance;

    public RaceByTurn(final int turn, final int distance) {
        this.turn = turn;
        this.distance = distance;
    }

    public int getTurn() {
        return turn;
    }

    public int getDistance() {
        return distance;
    }
}
