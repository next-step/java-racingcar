package com.next.step.step3.domain;

public class Car {

    private static final int INIT_POSITION = 0;

    private static final int MOVE_CONDITION = 4;

    private Position position;

    private CarName carName;

    public Car(String carName) {
        this.position = new Position(INIT_POSITION);
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
