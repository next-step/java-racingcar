package com.sryoondev.racingcar;

public class MyCar {
    private final Route route;

    public MyCar() {
        this.route = new Route();
    }

    public void move() {
        this.route.moveForward();
    }

    public void stop() {
        // do nothing
    }

    public void race(boolean movable) {
        if (movable) {
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
