package racingcar.domain;

import java.util.Objects;

public class Position {

    private static final int DEFAULT_POSITION = 0;
    private int position;

    public Position() {
        this(DEFAULT_POSITION);
    }

    public Position(int position) {
        this.position = position;
    }

    public void increase() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Position position1 = (Position) o;

        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(position);
    }
}
