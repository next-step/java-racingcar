package step4.model;

import java.util.Objects;

public class Distance {

    private final int distance;

    public Distance() {
        this(0);
    }

    public Distance(int distance) {
        if (distance < 0) {
            throw new IllegalArgumentException("The distance value must be greater than 0");
        }
        this.distance = distance;
    }

    public Distance maxDistance(Distance other) {
        if (other.distance > distance) {
            return other;
        }
        return this;
    }

    public Distance increase() {
        return new Distance(this.distance + 1);
    }

    public int distance() {
        return distance;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Distance otherDistance = (Distance) other;
        return distance == otherDistance.distance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }

}
