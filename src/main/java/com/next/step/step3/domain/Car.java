package com.next.step.step3.domain;

import com.next.step.step3.domain.vo.CarName;
import com.next.step.step3.domain.vo.Position;

public class Car {

    private static final int MOVE_CONDITION = 4;

    private Position position;

    private CarName carName;

    public Car(int position, String carName) {
        this.position = new Position(position);
        this.carName = new CarName(carName);
    }

    public void moveCar(int randomNum) {
        if (canMove(randomNum)) {
            this.position = position.movePosition();
        }
    }

    private boolean canMove(int randomNum) {
        return randomNum >= MOVE_CONDITION;
    }

    public int position() {
        return this.position.position();
    }

    public String name() {
        return carName.carName();
    }
}
