package racing.model;

import racing.strategy.GoStraightStrategy;

import java.util.Random;

public class Car {

    private int currentLocation;

    public Car(int startLocation) {
        this.currentLocation = startLocation;
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
