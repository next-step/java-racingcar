package step3.domain;

import step3.strategy.MovingStrategy;

public class Car {

    private int distance;

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.canForward()) {
            distance++;
        }
    }

    public int getDistance() {
        return this.distance;
    }
}
