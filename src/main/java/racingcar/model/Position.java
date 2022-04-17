package racingcar.model;

import java.util.Objects;
import java.util.stream.IntStream;

public class Position {
    public static final int DEFAULT = 0;
    private static final int INCREASE_POSITION_COUNT = 1;
    private static final int INITIAL_VALUE = 0;

    private int position;

    public Position(int position) {
        this.position = position;
    }

    public synchronized Position increase() {
        this.position = this.position + INCREASE_POSITION_COUNT;
        return this;
    }

    public int getPosition() {
        return this.position;
    }

    public boolean match(int position) {
        return this.position == position;
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
        return this.position == position.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        IntStream.range(INITIAL_VALUE, this.position)
                .forEach(action -> stringBuilder.append("-"));

        return stringBuilder.toString();
    }
}
