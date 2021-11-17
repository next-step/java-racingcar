package com.kkambi.racing.domain;

public class Car {

    private static final int criteriaToMove = 4;

    private Location location;
    private final Name name;

    public Car(final int location, final String name) {
        this.location = new Location(location);
        this.name = new Name(name);
    }

    public void tryToMove(int randomValue) {
        if (randomValue >= criteriaToMove) {
            this.location = location.move();
        }
    }

    public Location getLocation() {
        return location;
    }

    public Name getName() {
        return name;
    }
}
