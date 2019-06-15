package com.jaeyeonling.racingcar.domain;

class Car {

    private static final int DEFAULT_POSITION = 1;

    private int position = DEFAULT_POSITION;

    void moveForward() {
        position++;
    }

    int getPosition() {
        return position;
    }

    public CarStatus getStatus() {
        return new CarStatus(this);
    }
}
