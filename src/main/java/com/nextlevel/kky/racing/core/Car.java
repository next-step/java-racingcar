package com.nextlevel.kky.racing.core;

public class Car {

    private String name;

    private int currentPosition;

    private final CarMoveCondition carMoveCondition;

    public String getName() {
        return name;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public Car() {
        this.currentPosition = 0;
        this.carMoveCondition = new CarMoveCondition(new RandomIntegerGenerator());
    }

    public Car(String name) {
        this.name = name;
        this.currentPosition = 0;
        this.carMoveCondition = new CarMoveCondition(new RandomIntegerGenerator());
    }

    public Car(String name, IntegerGenerator integerGenerator) {
        this.name = name;
        this.carMoveCondition = new CarMoveCondition(integerGenerator);
    }

    public void move() {
        if (carMoveCondition.checkMoveCondition()) {
            currentPosition++;
        }
    }
}
