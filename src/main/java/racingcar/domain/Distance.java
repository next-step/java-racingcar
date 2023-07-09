package racingcar.domain;

import java.util.Objects;

public class Distance {

    public static final int ZERO_DISTANCE = 0;
    
    private int distance;

    public Distance(int distance) {
        this.distance = distance;
    }

    public Distance() {
        this(ZERO_DISTANCE);
    }

    public void increase() {
        distance++;
    }

    public boolean isSameDistance(int distance) {
        return this.distance == distance;
    }

    public boolean isSameDistance(Distance distance) {
        return this.distance == distance.distance;
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

    @Override
    public String toString() {
        return "Distance{" +
                "distance=" + distance +
                '}';
    }

    public boolean isGreaterThan(Distance distance) {
        return this.distance > distance.distance;
    }
}
