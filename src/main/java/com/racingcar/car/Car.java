package com.racingcar.car;

public class Car {
    private int distance = 1;
    private final static int MOVE_STANDARD = 4;

    protected int id;

    protected Car() {

    }

    public Car(int id) {
        this.id = id;
    }


    public void move(int value) {
        if (value < MOVE_STANDARD) {
            return;
        }

        distance++;
    }

    public int getDistance() {
        return distance;
    }

    public int getId() {
        return id;
    }
}
