package racingcar.domain;

import java.util.Objects;

public class Position {
    private static final String CHECK_MIN = "이동 범위가 최소 값인 0보다 작은 음수 값인지 확인해주세요.";
    private static final int POSITION_MIN = 0;
    private final int position;

    public Position() {
        this(POSITION_MIN);
    }

    public Position(int position) {
        validate(position);
        this.position = position;
    }

    public Position move() {
        return new Position(position + 1);
    }

    public int toInteger() {
        return position;
    }

    public boolean isBiggerThan(Position maxPosition) {
        return this.toInteger() > maxPosition.toInteger();
    }

    private void validate(int position) {
        checkNegative(position);
    }

    private void checkNegative(int position) {
        if (position < POSITION_MIN) {
            throw new IllegalArgumentException(CHECK_MIN);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
