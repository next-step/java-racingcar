package com.jaenyeong.mission2.racingcar.domain;

public class Car {
    private Distance dist;

    public Car() {
        this.dist = new Distance();
    }

    public void move() {
        this.dist = dist.move();
    }

    public int getCurrentDistance() {
        return dist.getDist();
    }
}
