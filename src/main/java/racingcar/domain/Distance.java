package racingcar.domain;

import racingcar.exception.NegativeInitialDistanceException;

import java.util.Objects;

public class Distance {

    private int distance;

    // Primary Constructor, 주생성자
    public Distance(int initValue) {
        validateDistance(initValue);
        this.distance = initValue;
    }

    public Distance() {
        this(0);
    }

    // Constructor for UnitTest

    private void validateDistance(int initValue) {
        if (isNegative(initValue)) {
            throw new NegativeInitialDistanceException(initValue);
        }
    }

    private boolean isNegative(int initValue) {
        return initValue < 0;
    }

    public void increase() {
        this.distance++;
    }

    public int get() {
        return this.distance;
    }


    public Distance max(Distance distance) {
        if (this.distance > distance.distance) {
            return this;
        }
        return distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Distance distance1 = (Distance) o;
        return distance == distance1.distance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }
}
