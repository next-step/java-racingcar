package com.step3.model.car;

import com.step3.model.car.strategy.MoveStrategy;

public class Car {
    private Name id;
    private Position position;
    private MoveStrategy moveStrategy;

    public Car(Name id, Position position, MoveStrategy moveStrategy) {
        this.id = id;
        this.position = position;
        this.moveStrategy = moveStrategy;
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

    public MoveStrategy getMoveStrategy() {
        return moveStrategy;
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