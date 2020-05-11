package com.nextstep.racingcar.domain;

public class Car {
    private int moveLength;

    private Car(int moveLength) {
        this.moveLength = moveLength;
    }

    public Car() {
        this(0);
    }

    public int getMoveLength() {
        return moveLength;
    }

    public void move(int value) {
        if(isMoveable(value)) {
            this.moveLength += 1;
        }
    }

    protected boolean isMoveable(int value) {
        return value >= 4;
    }
}
