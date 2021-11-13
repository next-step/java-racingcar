package racinggame.domain.value;

import racinggame.utils.MoveValueValidator;

import java.util.Objects;

public class Position {
    private static final int INIT_POSITION = 0;

    private int position;

    private Position(int position) {
        this.position = position;
    }

    public static Position createInitPosition() {
        return new Position(INIT_POSITION);
    }

    public static Position of(int position) {
        return new Position(position);
    }

    public void increase(int moveValue) {
        if (MoveValueValidator.validate(moveValue)) {
            position++;
        }
    }

    public boolean same(int position) {
        return this.position == position;
    }

    public int current() {
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
