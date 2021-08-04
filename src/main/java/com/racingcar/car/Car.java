package com.racingcar.car;

public class Car {
    private int distance = 1;
    private static final int MOVE_STANDARD = 4;
    private static final int NAME_MAX_LENGTH = 4;
    private final String name;

    public Car(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("name must under 4 characters, name : " + name);
        }

        this.name = name;
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

    public String getName() {
        return name;
    }
}
