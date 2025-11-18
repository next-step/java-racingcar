package racingCar;

import java.util.Objects;

public class Distance {
    private final int value;
    public Distance() {
        this(0);
    }
    public Distance(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public Distance plus() {
        return new Distance(this.value + 1);
    }

    public Distance greaterThan(int max) {
        return new Distance(Math.max(this.value, max));
    }
    public Distance greaterThan(Distance max) {
        return greaterThan(max.value());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Distance distance1 = (Distance) o;
        return value == distance1.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return "Distance{" +
                "value=" + value +
                '}';
    }
}
