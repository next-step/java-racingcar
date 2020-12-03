package com.nextstep.racinggame.domain;

import java.util.Objects;

public class Car {
    private final int distance;

    Car(final int distance) {
        this.distance = distance;
    }

    public static Car of() {
        return new Car(0);
    }

    public Car move(final GasStation gasStation) {
        Fuel fuel = gasStation.refuel();

        if (fuel.isEnough()) {
            return new Car(this.distance + 1);
        }

        return this;
    }

    int getDistance() {
        return distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return distance == car.distance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }

    @Override
    public String toString() {
        return "Car{" +
                "distance=" + distance +
                '}';
    }
}
