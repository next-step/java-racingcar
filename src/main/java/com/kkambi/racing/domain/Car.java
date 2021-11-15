package com.kkambi.racing.domain;

public class Car {

    private static final int criteriaToMove = 4;

    private int location = 0;

    public void tryToMove(int randomValue) {
        if (randomValue >= criteriaToMove) {
            this.location++;
        }
    }

    public int getLocation() {
        return location;
    }
}
