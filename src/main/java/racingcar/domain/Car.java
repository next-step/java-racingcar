package racingcar.domain;

import racingcar.policy.MovingPolicy;

public final class Car implements Comparable<Car> {
    private final CarName name;
    private Distance distance;

    public Car(CarName name) {
        this(name, new Distance());
    }

    public Car(final CarName name, final Distance distance) {
        this.name = name;
        this.distance = distance;
    }

    public void move(final MovingPolicy movingPolicy) {
        if (movingPolicy.isPossibleMove()) {
            distance.increase();
        }
    }

    public CarName getName() {
        return name;
    }

    public Distance currentDistance() {
        return distance;
    }

    @Override
    public int compareTo(final Car car) {
        return distance.toInt() - car.distance.toInt();
    }
}
