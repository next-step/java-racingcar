package com.step3.model.car;

import com.step3.model.car.strategy.MoveStrategy;

public class Car {
    private Name name;
    private Position position;

    public Car(Name id, Position position) {
        this.name = id;
        this.position = position;
    }

    public Car move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMove()) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Car car = (Car) o;
        return name.equals(car.name) && position.equals(car.position);
    }
}