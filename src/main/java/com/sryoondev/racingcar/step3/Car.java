package com.sryoondev.racingcar.step3;

public class Car {
    private int moveCount;

    public Car() {
        this.moveCount = 0;
    }

    private void move() {
        this.moveCount++;
    }

    public void race(boolean movable) {
        if (movable) {
            move();
        }
    }

    public int getMoveDistance() {
        return this.moveCount;
    }
}
