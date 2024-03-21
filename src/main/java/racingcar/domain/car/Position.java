package racingcar.domain.car;

import java.util.Objects;

public class Position implements Comparable<Position> {

    private static final String ICON = "-";

    private int value;

    Position(int value) {
        this.value = value;
    }

    void increase(final int amount) {
        this.value += amount;
    }

    Position copyOf() {
        return new Position(this.value);
    }

    @Override
    public boolean equals(final Object otherPosition) {
        if (this == otherPosition) {
            return true;
        }

        if (otherPosition == null || getClass() != otherPosition.getClass()) {
            return false;
        }

        return this.value == ((Position)otherPosition).value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.value);
    }

    @Override
    public int compareTo(final Position otherPosition) {
        return Integer.compare(this.value, otherPosition.value);
    }

    @Override
    public String toString() {
        return ICON.repeat(this.value);
    }
}
