package racing.core;

import java.util.Objects;

public class Distance {

    private static final int STEP_COUNT = 1;
    public static final int DEFAULT_MIN_BOUND = 1;

    private int distance;

    public Distance(int distance) {
        if(distance < DEFAULT_MIN_BOUND){
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
}
