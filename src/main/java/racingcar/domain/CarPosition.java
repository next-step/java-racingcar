package racingcar.domain;

import java.util.Objects;

public class CarPosition {
    private static final int POSITION_MIN_VALUE = 0;
    private int value;

    public CarPosition(int value) {
        validateBound(value);
        this.value = value;
    }

    private void validateBound(int position) {
        if (position < POSITION_MIN_VALUE) {
            throw new IllegalArgumentException(String.format("position(%d) should be bigger than %d", position, POSITION_MIN_VALUE));
        }
    }

    public int move() {
        return ++value;
    }

    public boolean isSame(CarPosition other) {
        return value == other.value;
    }

    public boolean isAheadOf(CarPosition position) {
        return value > position.value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CarPosition that = (CarPosition) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
