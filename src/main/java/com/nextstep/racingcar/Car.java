package com.nextstep.racingcar;

public class Car {
    private int position = 0;

    public void move() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    public boolean isNotFinished(int limit) {
        return position < limit;
    }
}
