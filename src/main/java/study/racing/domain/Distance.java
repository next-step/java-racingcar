package study.racing.domain;

import java.util.Objects;

import study.racing.exception.InvalidDistanceException;

public class Distance {

    private static final String DISTANCE_S_POSITION_MUST_GREATER_THAN_0 = "distance's position must greater than 0";
    private static final int INITIAL_DISTANCE = 0;

    private int position;

    public Distance(int position) {
        if (position < INITIAL_DISTANCE) {
            throw new InvalidDistanceException(DISTANCE_S_POSITION_MUST_GREATER_THAN_0);
        }
        this.position = position;
    }

    public static Distance init() {
        return new Distance(INITIAL_DISTANCE);
    }

    public void increase() {
        position++;
    }

    public int getPosition() {
        return position;
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
        return position == distance1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
