package racingcar.domain;

import java.util.Objects;

public class Position {
    private static final int MIN_VALUE = 0;
    private static final int MIN_AMOUNT = 0;

    private final int value;

    public Position() {
        this(0);
    }

    public Position(int value) {
        if (value < MIN_VALUE) {
            throw new IllegalArgumentException("[ERROR] 위치는 " + MIN_VALUE + "이상이어야 합니다.");
        }

        this.value = value;
    }

    public Position move(int amount) {
        if (amount < MIN_AMOUNT) {
            throw new IllegalArgumentException("[ERROR] 후진은 불가능합니다.");
        }

        return new Position(value + amount);
    }

    public int getDifferenceWith(Position position) {
        return this.value - position.value;
    }

    public int getValue() {
        return value;
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
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
