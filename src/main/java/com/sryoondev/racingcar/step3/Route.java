package com.sryoondev.racingcar.step3;

public class Route {
    private int moveCount;

    public Route() {
        this.moveCount = 0;
    }

    public void moveForward() {
        this.moveCount++;
    }

    public int getMoveCount() {
        return this.moveCount;
    }
}
