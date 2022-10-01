package racingcar.domain;

import java.util.Objects;

public class Distance {
    public static final Distance ZERO = new Distance(0);
    
    private final int distance;
    
    public Distance(int distance) {
        this.distance = distance;
    }

    public Distance increment() {
        return new Distance(distance + 1);
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Distance distance = (Distance) other;
        return this.distance == distance.distance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }
}
