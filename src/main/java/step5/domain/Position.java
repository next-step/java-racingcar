package step5.domain;

import java.util.Objects;

public class Position {

    public static final int MINUS_CHECK = 0;

    private int position;

    public Position(int position) {
        if (position < MINUS_CHECK) {
            throw new IllegalArgumentException("음수는 사용할 수 없습니다.");
        }
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void update() {
        position++;
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
