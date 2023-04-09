package com.next.step.step3.domain;

public class Car {

    private static final int MOVE_CONDITION = 4;

    private static final char MOVE_MARK = '-';

    private String position;

    public Car(String position) {
        this.position = position;
    }

    public void moveCar(int randomNum) {
        if (isMove(randomNum)) {
            this.position += MOVE_MARK;
        }
    }

    private boolean isMove(int randomNum) {
        return randomNum >= MOVE_CONDITION;
    }

    public String position() {
        return this.position;
    }
}
