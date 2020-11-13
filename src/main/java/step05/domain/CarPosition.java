package step05.domain;

import step03.strategy.MoveStrategy;
import validator.NumberValidator;

public class CarPosition {
    private final int position;
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

    public int getCarPosition() {
        return position;
    }

    public int compare(CarPosition otherPosition) {
        return position - otherPosition.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarPosition that = (CarPosition) o;
        return position == that.position;
    }

}
