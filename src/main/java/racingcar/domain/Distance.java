package racingcar.domain;

import java.util.Objects;

public class Distance {
    public static final int DEFAULT_DISTANCE = 0;

    private int value;

    public Distance() {
        this(DEFAULT_DISTANCE);
    }

    public Distance(final int distance) {
        this.value = distance;
    }

    public void increase() {
        value++;
    }

    public int toInt() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Distance distance1 = (Distance) o;
        return value == distance1.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
