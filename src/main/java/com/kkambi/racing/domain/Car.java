package com.kkambi.racing.domain;

import java.util.Objects;

public class Car implements Comparable<Car> {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(location, car.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location);
    }

    @Override
    public int compareTo(Car otherCar) {
        return location.compareTo(otherCar.getLocation());
    }
}
