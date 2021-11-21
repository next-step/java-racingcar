package com.kkambi.racing.domain;

import com.kkambi.racing.strategy.MovingStrategy;

import java.util.Objects;

public class Car implements Comparable<Car> {

    protected Location location;
    protected final Name name;
    private MovingStrategy movingStrategy;

    public Car(final int location, final String name) {
        this.location = new Location(location);
        this.name = new Name(name);
    }

    public void move() {
        this.location = movingStrategy.move(location);
    }

    public Location getLocation() {
        return location;
    }

    public Name getName() {
        return name;
    }

    public void setMovingStrategy(MovingStrategy movingStrategy) {
        this.movingStrategy = movingStrategy;
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
