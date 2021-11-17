package com.sryoondev.racingcar.step3;

public class Car {
    private final String name;
    private int moveCount = 0;

    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자를 초과할 수 없습니다.");
        }
        this.name = name;
    }

    private void move() {
        this.moveCount++;
    }

    public void race(boolean movable) {
        if (movable) {
            move();
        }
    }

    public int getMoveDistance() {
        return this.moveCount;
    }
}
