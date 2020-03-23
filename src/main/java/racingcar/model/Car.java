package racingcar.model;

import racingcar.policy.MovingPolicy;

public final class Car {
    private int distance;

    public Car() {
        this(0);
    }

    public Car(final int distance) {
        this.distance = distance;
    }

    public void move(final MovingPolicy movingPolicy) {
        if (movingPolicy.isPossibleMove()) {
            distance++;
        }
    }

    public int getDistance() {
        return distance;
    }
}
