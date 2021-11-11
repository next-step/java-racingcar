package com.step3.model.car;

public class Car {
    private static final int MOVE_POSSIBLE_BOUND = 4;

    private Name id;
    private Position position;

    public Car(Name id, Position position) {
        this.id = id;
        this.position = position;
    }

    public Car move(boolean isMoved) {
        if (isMoved) {
            this.position = new Position(this.position.getValue() + 1);
        }
        return this;
    }

    public Position getPosition() {
        return this.position;
    }

    public Name getId() {
        return this.id;
    }

    public static boolean isMovePossible(int randomValue) {
        return randomValue >= MOVE_POSSIBLE_BOUND;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Car car = (Car) o;
        return id.getValue() == car.id.getValue();
    }
}