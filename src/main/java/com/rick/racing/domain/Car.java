package com.rick.racing.domain;

import com.rick.racing.controller.CarMovingStrategy;
import java.util.Objects;

public class Car {

    private final CarName name;
    private final CarPosition position;

    private Car(final String name) {
        this.name = CarName.create(name);
        this.position = CarPosition.create();
    }

    private Car(final String name, final int position) {
        this.name = CarName.create(name);
        this.position = CarPosition.create(position);
    }

    public static Car create(final String name) {
        return new Car(name);
    }

    public static Car create(final String name, int position) {
        return new Car(name, position);
    }

    public void move(final CarMovingStrategy carMovingStrategy) {
        if (carMovingStrategy.isGo()) {
            position.increase();
        }
    }

    public CarName getName() {
        return name;
    }

    public CarPosition getPosition() {
        return position;
    }

    public boolean isPositionAt(final Car car) {
        return this.position.equals(car.position);
    }

    @Override
    public boolean equals(final Object target) {
        if (this == target) {
            return true;
        }
        if (target == null || getClass() != target.getClass()) {
            return false;
        }
        Car car = (Car) target;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
