package com.step3.model.car;

public class Car {
    private Name id;
    private Position position;

    public Car(Name id, Position position) {
        this.id = id;
        this.position = position;
    }

    public Car move(boolean isMoved) {
        this.position = position.add(isMoved);
        return this;
    }

    public Position getPosition() {
        return this.position;
    }

    public Name getId() {
        return this.id;
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