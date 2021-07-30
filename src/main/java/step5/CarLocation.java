package step5;

import java.util.Objects;

public class CarLocation {
    private final int value;

    public CarLocation() {
        this(0);
    }

    public CarLocation(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public CarLocation progress() {
        return new CarLocation(this.value + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarLocation that = (CarLocation) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
