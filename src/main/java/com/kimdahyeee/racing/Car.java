package com.kimdahyeee.racing;

import com.kimdahyeee.racing.rule.MovableStrategy;

public class Car implements Comparable<Car> {
    private int position;
    private String name;
    private MovableStrategy movableStrategy;

    public Car(String name, MovableStrategy movableStrategy) {
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
            position = position + 1;
        }
    }

    @Override
    public int compareTo(Car o) {
        return this.position - o.getPosition();
    }
}
