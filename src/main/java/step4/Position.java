package step4;

import java.util.Objects;

public class Position {
    private static final int INIT_NUM = 0;
    private static final int MOVE = 1;

    private int position = INIT_NUM;

    public void move() {
        this.position += MOVE;
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
