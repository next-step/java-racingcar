package racingcar.domain;

import java.util.Objects;

public class Distance {

    private int value;

    private Distance() {

    }

    private Distance(int value) {
        this.value = value;
    }

    public static Distance from() {
        return new Distance();
    }

    public static Distance valueOf(int value) {
        return new Distance(value);
    }

    public void move() {
        value++;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Distance distance = (Distance) o;
        return value == distance.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
