package com.kimdahyeee.racing;

import com.kimdahyeee.racing.rule.Movable;

public class Car implements Comparable<Car> {
    private int position;
    private String name;
    private Movable movable;

    public Car(String name, Movable movable) {
        this.name = name;
        this.movable = movable;
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
        if (movable.canMove()) {
            position = position + 1;
        }
    }

    @Override
    public int compareTo(Car o) {
        return this.position - o.getPosition();
    }
}
