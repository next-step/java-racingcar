package com.kimdahyeee.racing;

import com.kimdahyeee.racing.rule.MovableStrategy;

public class Car implements Comparable<Car> {
    private int position;
    private final String name;
    private final MovableStrategy movableStrategy;

    public Car(final String name, final MovableStrategy movableStrategy) {
        this.name = name;
        this.movableStrategy = movableStrategy;
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
        if (movableStrategy.canMove()) {
            ++position;
        }
    }

    @Override
    public int compareTo(Car o) {
        return this.position - o.getPosition();
    }
}
