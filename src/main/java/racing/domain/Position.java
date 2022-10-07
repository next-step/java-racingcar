package racing.domain;

import java.util.Objects;

public class Position {

    private static final int MOVE = 1;

    private int position;

    public Position(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void move(MovableStrategy movableStrategy) {
        if (movableStrategy.randomMovable()) {
            position += MOVE;
        }
    }

    public boolean equalsPosition(int maxPosition) {
        return position == maxPosition;
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
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
