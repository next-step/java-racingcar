package com.java.jaeheon.step2.model;

public class Car {
    private final int MOVING_CONDITION = 4;

    private int numberOfAttempts;
    private int distance;

    public Car() {
        this.numberOfAttempts = 0;
        this.distance = 0;
    }

    public Car attempt(int condition) {
        if (MOVING_CONDITION <= condition) {
            move();
        }
        ++numberOfAttempts;
        return this;
    }

    private void move() {
        distance++;
    }

    public int getDistance() {
        return distance;
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }
}
