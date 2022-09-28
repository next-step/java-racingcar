package racing.model;

import racing.strategy.GoStraightStrategy;

import java.util.Random;

public class Car implements Comparable<Car> {

    private int currentLocation;

    private Name name;

    public Car(int startLocation, String name) {
        this(new Name(name));
        this.currentLocation = startLocation;
    }

    public Car(Name name) {
        this.name = name;
    }

    public String getName() {
        return name.getName();
    }

    public int getCurrentLocation() {
        return this.currentLocation;
    }

    public void goStraight(GoStraightStrategy goStraightStrategy) {
        if (goStraightStrategy.isGoStraight()) {
            this.currentLocation++;
        }
    }

    @Override
    public int compareTo(Car o) {
        if (this.currentLocation < o.getCurrentLocation()) return 1;
        return -1;
    }
}
