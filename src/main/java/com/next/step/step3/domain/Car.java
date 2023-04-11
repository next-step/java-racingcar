package com.next.step.step3.domain;

public class Car {

    private static final int INIT_POSITION = 0;

    private static final int MOVE_CONDITION = 4;

    private Position position;

    public Car() {
        this.position = new Position(INIT_POSITION);
    }

    public void moveCar(int randomNum) {
        if (canMove(randomNum)) {
            this.position.movePosition();
        }
    }

    private boolean canMove(int randomNum) {
        return randomNum >= MOVE_CONDITION;
    }

    public int position() {
        return this.position.position();
    }

    public boolean isMoved() {
        return position.position() == INIT_POSITION;
    }
}
