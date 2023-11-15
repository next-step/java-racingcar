package racingCar.domain;

import java.util.Objects;

public class Distance {
    private int distance;

    public Distance() {
        this.distance = 0;
    }

    public Distance(int distance) {
        if (checkIfDistanceIsPositiveOrZero(distance)) {
            this.distance = distance;
        }
    }

    private boolean checkIfDistanceIsPositiveOrZero(int distance) {
        if (distance < 0) {
            throw new IllegalArgumentException("Negative number is not allowed for distance");
        }
        return Boolean.TRUE;
    }

    public void moveForward() {
       distance++;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Distance distance1 = (Distance) o;
        return distance == distance1.distance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }
}
