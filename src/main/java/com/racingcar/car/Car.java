package com.racingcar.car;

import com.racingcar.game.result.RoundCarRecord;

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

    public RoundCarRecord move(int value) {
        if (value >= MOVE_STANDARD) {
            distance++;
        }

        return RoundCarRecord.of(this);
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    public boolean isWinner(int maxDistance) {
        return distance == maxDistance;
    }
}
