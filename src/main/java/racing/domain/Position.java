package racing.domain;

import racing.data.Messages;

import java.util.Objects;

public class Position {

    int value = 0;

    public Position(int value) {
        if (value < 0) {
            throw new IllegalArgumentException(Messages.INVALID_NUMBER_RANGE);
        }
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public void increase() {
        this.value++;
    }

    public int max(int position) {
        return Math.max(this.value, position);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
