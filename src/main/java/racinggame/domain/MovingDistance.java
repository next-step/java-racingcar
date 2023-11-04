package racinggame.domain;

import java.util.Objects;

public class MovingDistance {

    public static final int DEFAULT_DISTANCE = 0;
    public static final int DEFAULT_ADD_DISTANCE = 1;
    private int distance;

    public MovingDistance(int distance) {
        this.distance = distance;
    }

    public MovingDistance() {
        this.distance = DEFAULT_DISTANCE;
    }

    public void add() {
        this.distance = this.distance + DEFAULT_ADD_DISTANCE;
    }

    public int distance() {
        return this.distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MovingDistance that = (MovingDistance) o;
        return distance == that.distance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }

}
