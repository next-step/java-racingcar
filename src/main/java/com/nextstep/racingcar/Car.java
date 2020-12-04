package com.nextstep.racingcar;

public class Car {
    private final int limit;
    private int position = 0;

    public Car(int limit) {
        this.limit = limit;
    }

    public void move() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    public boolean isNotFinished() {
        return position < limit;
    }
}
