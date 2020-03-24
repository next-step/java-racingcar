package racingcar.model;

import racingcar.policy.MovingPolicy;

public final class Car implements Comparable<Car> {
    public static final int DEFAULT_DISTANCE = 0;
    private String name;
    private int distance;

    public Car(String name) {
        this(name, DEFAULT_DISTANCE);
    }

    public Car(final String name, final int distance) {
        this.name = name;
        this.distance = distance;
    }

    public void move(final MovingPolicy movingPolicy) {
        if (movingPolicy.isPossibleMove()) {
            distance++;
        }
    }

    public String getName() {
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
