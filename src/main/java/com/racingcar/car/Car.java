package com.racingcar.car;

public class Car {
    private int distance = 1;

    public void move(int value) {
        if (value < 4) {
            return;
        }

        distance++;
    }

    public int getDistance() {
        return distance;
    }
}
