package com.sryoondev.racingcar.step3;

public class Car {
    private final Route route;

    public Car() {
        this.route = new Route();
    }

    public void move() {
        this.route.moveForward();
    }

    public void race(boolean movable) {
        if (movable) {
            move();
        }
    }

    public String getMovement() {
        return route.getLines();
    }

    public int getMoveDistance() {
        return route.getMoveCount();
    }
}
