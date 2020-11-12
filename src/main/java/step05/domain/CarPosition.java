package step05.domain;

import step03.strategy.MoveStrategy;
import validator.NumberValidator;

import java.util.Objects;

public class CarPosition {
    private int position;
    private static final int defaultPosition = 1;

    private CarPosition(int position) {
        this.position = position;
        isPositiveInteger();
    }

    public static CarPosition of() {
        return new CarPosition(defaultPosition);
    }

    public static CarPosition of(int position) {
        return new CarPosition(position);
    }

    private void isPositiveInteger() {
        NumberValidator.validatePositiveInteger(position);
    }

    public CarPosition move(MoveStrategy moveStrategy) {
        if (moveStrategy.isGoing()) {
            return CarPosition.of(position + 1);
        }
        return CarPosition.of(position);
    }

    public CarPosition getCarPosition() {
        return new CarPosition(position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarPosition that = (CarPosition) o;
        return position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

}
