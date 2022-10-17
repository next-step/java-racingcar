package racingcar.domain;

import java.util.Objects;

public class Position {

    private final int value;

    public Position(final int value) {
        this.value = value;
    }

    public Position increase(final int i) {
        return new Position(value + i);
    }

    public boolean isSameValue(final int bound) {
        return value == bound;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Position)) {
            return false;
        }

        return this.value == ((Position) o).value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
