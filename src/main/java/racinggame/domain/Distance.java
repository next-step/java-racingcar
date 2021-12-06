package racinggame.domain;

import java.util.Objects;

public class Distance {
    private final int value;

    public Distance(final int value) {
        this.value = value;
    }

    public Distance move() {
        return new Distance(value + 1);
    }

    public int getDistance() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Distance)) {
            return false;
        }

        Distance distance = (Distance) o;
        return value == distance.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
