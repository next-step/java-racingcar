package com.sryoondev.racingcar.step3;

public class Record {
    private final String name;
    private final int distance;

    public Record(Car car) {
        this.name = car.getName();
        this.distance = car.getMoveDistance();
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
