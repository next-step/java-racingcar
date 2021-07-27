package racingcar.domain;

import java.util.Objects;

public class Distance implements Comparable<Distance> {

    private final int value;

    private Distance(int value) {
        this.value = value;
    }

    public static Distance from(int value) {
        return new Distance(value);
    }

    public Distance move() {
        return new Distance(this.value + 1);
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

    @Override
    public int compareTo(Distance o) {
        return this.value - o.value;
    }
}
