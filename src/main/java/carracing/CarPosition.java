package carracing;

import java.util.Objects;

public class CarPosition {
    private final int value;

    public CarPosition() {
        this.value = 0;
    }
    public CarPosition(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarPosition that = (CarPosition) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public CarPosition increase() {
        return new CarPosition(this.value + 1);
    }

    public int getMax(int max) {
        return Math.max(max, this.value);
    }
}
