package study.racing.domain;

import java.util.Objects;

public class Distance {

    public static final int INITIAL_DISTANCE = 0;

    private int distance;

    public Distance(int distance) {
        this.distance = distance;
    }

    public static Distance init() {
        return new Distance(INITIAL_DISTANCE);
    }

    public void increase() {
        distance++;
    }

    public int getDistance() {
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
