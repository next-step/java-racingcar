package racingcar.vo;

import java.util.Objects;

public class CarPosition {

    private static final int ONE_STEP = 1;

    private final int value;

    public CarPosition(int value) {
        this.value = value;
    }

    public static CarPosition initialize() {
        return new CarPosition(ONE_STEP);
    }

    public CarPosition move() {
        return new CarPosition(this.value + ONE_STEP);
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarPosition that = (CarPosition) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}

