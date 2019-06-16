package com.jaeyeonling.racingcar.domain;

class Car {

    static final int DEFAULT_POSITION = 1;

    private int position;

    Car() {
        this(DEFAULT_POSITION);
    }

    Car(final int position) {
        this.position = position;
    }

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
