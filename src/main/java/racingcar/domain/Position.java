package racingcar.domain;

import java.util.Objects;

public class Position {

    private final int number;

    public Position(final int number) {
        this.number = number;
    }

    public Position increase(int i) {
        return new Position(number + i);
    }

    public boolean isSameNumber(final int bound) {
        return number == bound;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Position)) {
            return false;
        }

        return this.number == ((Position) o).number;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }
}
