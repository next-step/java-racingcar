package racingcar.model;

import racingcar.policy.MovingPolicy;

public final class Car {
    private static final int DEFAULT_DISTANCE = 0;
    private int distance;

    public Car() {
        this(DEFAULT_DISTANCE);
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
