package com.nextstep.racinggame.domain;

public class Car {
    private final GasStation gasStation;
    private int distance;

    public Car(final GasStation gasStation) {
        this.gasStation = gasStation;
        this.distance = 0;
    }

    public int getDistance() {
        return distance;
    }

    public void move() {
        Fuel fuel = gasStation.refuel();

        if (fuel.isEnough()) {
            this.distance += 1;
        }
    }
}
