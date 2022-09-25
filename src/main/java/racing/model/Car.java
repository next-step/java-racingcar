package racing.model;

import racing.strategy.GoStraightStrategy;

import java.util.Random;

public class Car {
    private static final int START_LOCATION = 0;

    private int currentLocation;

    public Car() {
        this.currentLocation = START_LOCATION;
    }

    public int getCurrentLocation() {
        return this.currentLocation;
    }

    public void goStraight(GoStraightStrategy goStraightStrategy) {
        if (goStraightStrategy.isGoStraight()) {
            this.currentLocation++;
        }
    }
}
