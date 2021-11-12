package com.sryoondev.racingcar;

public class MyCar {
    private static final int MOVABLE_THRESHOLD = 4;
    private Route route;

    public MyCar() {
        this.route = new Route();
    }

    public void move() {
        this.route.moveForward();
    }

    public void stop() {
        // do nothing
    }

    public void race(int randomNumber) {
        if (randomNumber >= MOVABLE_THRESHOLD) {
            move();
        }
    }

    public String printRoute() {
        return route.printLines();
    }

    public int getMoveDistance() {
        return route.getMoveCount();
    }
}
