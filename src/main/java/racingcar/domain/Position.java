package racingcar.domain;

import java.util.Objects;

public class Position {
    public static final String POSITION_CANNOT_BE_NEGATIVE_NUMBER_EXCEPTION = "포지션은 양수만 가능합니다.";
    private final long number;

    public Position(long number) {
        validatePositionNumber(number);
        this.number = number;
    }

    private void validatePositionNumber(long number) {
        if (isMinus(number)) {
            throw new IllegalArgumentException(POSITION_CANNOT_BE_NEGATIVE_NUMBER_EXCEPTION);
        }
    }

    private boolean isMinus(long number) {
        return number < 0;
    }

    public Position move() {
        return new Position(this.number + 1);
    }

    public int sizeComparison(long number) {
        return (int) Math.max(this.number, number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return number == position.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
