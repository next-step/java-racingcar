package com.racingcar.game.result;

import com.racingcar.car.Car;

public class RoundCarRecord {
    private final String name;
    private final int distance;

    private RoundCarRecord(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public static RoundCarRecord of(Car car) {
        return new RoundCarRecord(car.getName(), car.getDistance());
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
