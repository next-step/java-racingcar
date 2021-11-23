package com.sryoondev.racingcar.step3;

public class Record {
    private final String name;
    private final int distance;

    public Record(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public Record(Car car) {
        this(car.getName(), car.getMoveDistance());
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public Record getWinner(Record anotherRecord) {
        if (distance > anotherRecord.getDistance()) {
            return this;
        }
        return anotherRecord;
    }
}
