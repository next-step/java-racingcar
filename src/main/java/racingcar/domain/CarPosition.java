package racingcar.domain;

import java.util.Objects;

public class CarPosition {
    public static final String NEGATIVE_VALUE_MESSAGE = "position은 음수 값을 가질 수 없습니다.";

    private int position;

    public CarPosition() {
        this(0);
    }

    public CarPosition(int position) {
        if (position < 0) {
            throw new IllegalArgumentException(NEGATIVE_VALUE_MESSAGE);
        }
        this.position = position;
    }

    public CarPosition plus() {
        position++;
        return this;
    }

    public boolean isLessThan(CarPosition maxPosition) {
        return this.position < maxPosition.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarPosition carPosition1 = (CarPosition) o;
        return position == carPosition1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

}
