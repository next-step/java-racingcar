package com.kimdahyeee.racing;

import java.util.Random;

public class Car {
    private static final int GO_STRAIGHT_LIMIT = 4;
    private static final int RANDOM_BOUND = 10;
    private int position;

    public Integer getPosition() {
        return position;
    }

    protected void move() {
        boolean canMove = getRandomNumber() >= GO_STRAIGHT_LIMIT;

        if (canMove) {
            position = position + 1;
        }
    }

    protected int getRandomNumber() {
        return new Random().nextInt(RANDOM_BOUND);
    }
}
