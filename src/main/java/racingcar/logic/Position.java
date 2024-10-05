package racingcar.logic;

import java.util.Objects;

public class Position {
    private static final String NEGATIVE_POSITION_MESSAGE = "음수 포지션은 존재할 수 없습니다.";
    private static final int MOVE_AMOUNT = 1;

    private final int position;

    private Position(int position) {
        this.position = position;
    }

    public static Position valueOf(int position) {
        if (position < 0) {
            throw new IllegalArgumentException(NEGATIVE_POSITION_MESSAGE);
        }
        return new Position(position);
    }

    public Position move() {
        return Position.valueOf(this.position + MOVE_AMOUNT);
    }

    public int getPosition() {
        return this.position;
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
        return Objects.hashCode(position);
    }
}
