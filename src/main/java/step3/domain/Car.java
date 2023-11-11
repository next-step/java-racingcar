package step3.domain;

import step3.strategy.MovingStrategy;

public class Car {
    private int distance = 0;

    public void move(MovingStrategy strategy) {
        if (strategy.isForward()) {
            this.distance++;
        }
    }

    public int getDistance() {
        return this.distance;
    }
}
