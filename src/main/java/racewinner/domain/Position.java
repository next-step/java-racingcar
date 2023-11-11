package racewinner.domain;

import java.util.Objects;

public class Position {
    private final static String NEGATIVE_NUMBER_MSG = "position 객체는 음수를 가질 수 없습니다.";
    private final static String STEP_STRING = "-";
    private final int NEGATIVE_NUMBER = 0;
    private int value;

    public Position(final int position) {
        validationCheck(position);
        this.value = position;
    }

    private void validationCheck(final int position) {
        if (position < NEGATIVE_NUMBER) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_MSG);
        }
    }

    public void move() {
        this.value++;
    }

    private int get() {
        return value;
    }

    public boolean isGreaterThan(final Position position) {
        return this.value > position.get();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Position position1 = (Position) o;
        return value == position1.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return STEP_STRING.repeat(value);
    }
}
