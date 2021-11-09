package racingcar.domain;

import java.util.Objects;

public class Position {
    private static final int INIT_POSITION = 0;

    private int position;

    private Position(int position) {
        this.position = position;
    }

    public static Position from(int position) {
        return new Position(position);
    }

    public static Position init() {
        return new Position(INIT_POSITION);
    }

    public void move(int moveValue) {
        this.position += moveValue;
    }

    public int getPosition() {
        return position;
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
