package com.next.step.step3.domain;

public class Car {

    private static final int MOVE_CONDITION = 4;

    private Position position;

    public Car(String position) {
        this.position = new Position(position);
    }

    public void moveCar(int randomNum) {
        if (isMove(randomNum)) {
            this.position.movePosition();
        }
    }

    private boolean isMove(int randomNum) {
        return randomNum >= MOVE_CONDITION;
    }

    public String position() {
        return this.position.position();
    }
}
