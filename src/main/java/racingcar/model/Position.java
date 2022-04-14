package racingcar.model;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Position {
    private static final int INCREASE_POSITION_COUNT = 1;
    private static final int INITIAL_VALUE = 0;
    private static final int DEFAULT_POSITION = 0;

    private final AtomicInteger position;

    public Position() {
        this(DEFAULT_POSITION);
    }

    public Position(int position) {
        this(new AtomicInteger(position));
    }

    public Position(AtomicInteger position) {
        this.position = position;
    }

    public Position increase() {
        return new Position(
                this.position.intValue() + INCREASE_POSITION_COUNT
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Position position1 = (Position) o;
        return Objects.equals(position.intValue(), position1.position.intValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        IntStream.range(INITIAL_VALUE, this.position.intValue())
                .forEach(action -> stringBuilder.append("-"));

        return stringBuilder.toString();
    }

}
