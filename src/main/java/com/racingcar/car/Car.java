package com.racingcar.car;

public class Car {
    private int distance = 1;
    private final static int MOVE_STANDARD = 4;

    public void move(int value) {
        if (value < MOVE_STANDARD) {
            return;
        }

        distance++;
    }

    public int getDistance() {
        return distance;
    }
}
