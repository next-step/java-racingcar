package racingcar.domain;

import java.util.Objects;

public final class CarPosition {
    private static final int STEP = 1;
    private final int position;

    public CarPosition(final int position) {
        this.position = position;
    }

    public int getPosition() {
        return this.position;
    }

    public CarPosition increasePosition() {
        return new CarPosition(this.position + STEP);
    }

    public CarPosition maxPosition(CarPosition maxPosition) {
        if (this.position > maxPosition.position) {
            return this;
        }
        return maxPosition;
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
