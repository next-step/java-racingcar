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

    public boolean sameScore(int maxScore) {
        return this.position == maxScore;
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
        return this.position - o.getPosition();
    }
}
