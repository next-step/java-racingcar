package racingcar.domain;

import racingcar.policy.MovingPolicy;

public final class Car implements Comparable<Car> {
    public static final int DEFAULT_DISTANCE = 0;

    private CarName name;
    private int distance;

    public Car(CarName name) {
        this(name, DEFAULT_DISTANCE);
    }

    public Car(final CarName name, final int distance) {
        this.name = name;
        this.distance = distance;
    }

    public void move(final MovingPolicy movingPolicy) {
        if (movingPolicy.isPossibleMove()) {
            distance++;
        }
    }

    public CarName getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(final Car car) {
        return this.distance - car.distance;
    }
}
