package com.nextlevel.kky.racing.core;

public class Car {

    private final String name;

    private final CarMoveCondition carMoveCondition;

    private final Position currentPosition;

    public String getName() {
        return name;
    }

    public int getCurrentPosition() {
        return currentPosition.getCurrentPosition();
    }

    public Car(String name) {
        this.name = name;
        this.currentPosition = new Position();
        this.carMoveCondition = new CarMoveCondition(new RandomIntegerGenerator());
    }

    public Car(String name, IntegerGenerator integerGenerator, int startPosition) {
        this.name = name;
        this.carMoveCondition = new CarMoveCondition(integerGenerator);
        this.currentPosition = new Position(startPosition);
    }

    public void move() {
        if (carMoveCondition.checkMoveCondition()) {
            currentPosition.forwardPosition();
        }
    }
}
