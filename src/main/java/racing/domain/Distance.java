package racing.domain;

import java.util.Objects;

public class Distance implements Comparable{

    private static final int STEP_COUNT = 1;
    public static final int MIN_DISTANCE_BOUND = 1;

    private int distance;

    public Distance(int distance) {
        if (distance < MIN_DISTANCE_BOUND) {
            throw new IllegalArgumentException("car distance should be bigger than 0");
        }
        this.distance = distance;
    }

    void stepAhead() {
        this.distance += STEP_COUNT;
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
    public int compareTo(Object o) {
        int targetDistance = ((Distance) o).getDistance();
        return distance - targetDistance;
    }
}
