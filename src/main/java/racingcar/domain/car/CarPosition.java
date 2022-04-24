package racingcar.domain.car;

import java.util.Objects;

public class CarPosition {
    private static final int DEFAULT_POSITION = 0;
    private static final int MOVABLE_DISTANCE = 1;

    private final int position;

    private CarPosition() {
        this(DEFAULT_POSITION);
    }

    public CarPosition(int position) {
        validate(position);
        this.position = position;
    }

    private void validate(int position) {
        if (position < DEFAULT_POSITION) {
            throw new IllegalArgumentException(String.format("position(%d)은 %d 이상이어야 합니다.", position, DEFAULT_POSITION));
        }
    }

    public CarPosition increase() {
        return new CarPosition(position + MOVABLE_DISTANCE);
    }

    public static CarPosition createDefault() {
        return new CarPosition();
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarPosition that = (CarPosition) o;
        return getPosition() == that.getPosition();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPosition());
    }
}
