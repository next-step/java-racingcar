package com.nextstep.racinggame.domain;

import java.util.Objects;

public class Car {
    private final int distance;
    private final Name name;

    Car(final int distance, final Name name) {
        this.distance = distance;
        this.name = name;
    }

    public static Car of(Name name) {
        return new Car(0, name);
    }

    public Car move(final MovePolicy movePolicy) {
        if (movePolicy.canMove()) {
            return new Car(this.distance + 1, this.name);
        }

        return this;
    }

    public String getName() {
        return this.name.getValue();
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return distance == car.distance &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance, name);
    }

    @Override
    public String toString() {
        return "Car{" +
                "distance=" + distance +
                ", name=" + name +
                '}';
    }
}
