package racingcar.domain;

import java.util.Objects;

public class CarPosition {
    public static final int INIT_POSITION = 0;
    public static final String NEGATIVE_VALUE_MESSAGE = "position은 음수 값을 가질 수 없습니다.";

    private final int position;

    public CarPosition() {
        this(INIT_POSITION);
    }

    public CarPosition(final int position) {
        if (position < INIT_POSITION) {
            throw new IllegalArgumentException(NEGATIVE_VALUE_MESSAGE);
        }
        this.position = position;
    }

    public CarPosition plus() {
        return new CarPosition(position + 1);
    }

    public boolean isLessThan(CarPosition maxPosition) {
        return this.position < maxPosition.position;
    }

    int getPosition() {
        return position;
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
