package com.nextlevel.kky.racing;

public class Car {

    private int currentPosition;
    private final CarMoveCondition carMoveCondition;

    public int getCurrentPosition() {
        return currentPosition;
    }

    public Car() {
        this.currentPosition = 0;
        this.carMoveCondition = new CarMoveCondition(new RandomIntegerGenerator());
    }

    public Car(IntegerGenerator integerGenerator) {
        this.currentPosition = 0;
        this.carMoveCondition = new CarMoveCondition(integerGenerator);
    }

    public void move() {
        if (carMoveCondition.checkMoveCondition()) {
            currentPosition++;
        }
    }
}
