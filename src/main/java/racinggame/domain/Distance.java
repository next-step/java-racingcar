package racinggame.domain;

import java.util.Objects;

public class Distance {

    public static final int DEFAULT_DISTANCE = 0;
    public static final int DEFAULT_ADD_DISTANCE = 1;
    private int distance;

    public Distance(int distance) {
        this.distance = distance;
    }

    public Distance() {
        this.distance = DEFAULT_DISTANCE;
    }

    public void add() {
        this.distance = this.distance + DEFAULT_ADD_DISTANCE;
    }

    public int distance() {
        return this.distance;
    }

    public boolean isLongger(Distance comparisonDistance) {
        return this.distance > comparisonDistance.distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Distance that = (Distance) o;
        return distance == that.distance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }

}
