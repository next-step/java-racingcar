package com.seok.racing.domain;


import java.util.Objects;

public class Car {

    private final Racer racer;
    private Position position;

    protected Car(Racer racer) {
        this(racer, new Position());
    }

    protected Car(Racer racer, Position position) {
        this.racer = racer;
        this.position = position;
    }

    protected Record move() {
        return this.move(new RandomMovable());
    }

    protected Record move(Movable movable) {
        if (movable.isMovable())
            position.increment();
        return new Record(racer, position.clone());
    }

    public Winner awarded() {
        return new Winner(racer);
    }

    public Car fastThan(Car car) {
        return this.position.fastThan(car.position) ? this : car;
    }

    public boolean isTie(Car car) {
        return this.position.equals(car.position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(racer, car.racer) &&
                Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(racer, position);
    }
}
