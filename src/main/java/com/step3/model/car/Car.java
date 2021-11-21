package com.step3.model.car;

import com.step3.model.car.strategy.MoveStrategy;

public class Car {
    private Name name;
    private Position position;
    private MoveStrategy moveStrategy;

    public Car(Name id, Position position, MoveStrategy moveStrategy) {
        this.name = id;
        this.position = position;
        this.moveStrategy = moveStrategy;
    }

    public Car move(boolean isMoved) {
        if (isMoved) {
            this.position = this.position.add();
        }
        return this;
    }

    public Car move(int randomValue) {
        if (moveStrategy.isMove(randomValue)) {
            this.position = this.position.add();
        }
        return this;
    }

    public Position getPosition() {
        return this.position;
    }

    public Name getName() {
        return this.name;
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
        return name.equals(car.name);
    }
}