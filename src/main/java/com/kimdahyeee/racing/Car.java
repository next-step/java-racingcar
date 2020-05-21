package com.kimdahyeee.racing;

import java.util.Random;

public class Car implements Comparable<Car> {
    private static final int GO_STRAIGHT_LIMIT = 4;
    private static final int RANDOM_BOUND = 10;
    private int position;
    private String name;

    public Car(String name) {
        this.name = name;
    }

    public Integer getPosition() {
        return position;
    }

    public String getName() {
        return name;
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

    @Override
    public int compareTo(Car o) {
        if (this.position < o.getPosition()) {
            return -1;
        }

        return 1;
    }
}
