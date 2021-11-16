package com.rick.racing.model;

public class Car implements Comparable<Car> {

    private static final int INITIAL_VALUE = 0;

    private final CarName name;
    private final CarPosition position;

    private Car(String name) {
        this.name = CarName.create(name);
        this.position = CarPosition.create(INITIAL_VALUE);
    }

    public static Car create(String name) {
        return new Car(name);
    }

    public void moveForward() {
        position.increase();
    }

    public CarName name() {
        return name;
    }

    public CarPosition position() {
        return position;
    }

    public boolean isPositionAt(Car car) {
        return this.position.equals(car.position);
    }

    public boolean hasSameName(Car car) {
        return this.name.equals(car.name);
    }

    @Override
    public int compareTo(Car o) {
        return this.position.compareTo(o.position);
    }
}
