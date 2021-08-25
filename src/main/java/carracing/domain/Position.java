package carracing.domain;

import java.util.Objects;

public class Position {

    private int position;

    public Position() {
        this(0);
    }

    public Position(int position) {
        checkPosition(position);

        this.position = position;
    }

    private void checkPosition(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("현재 위치는 음수가 될 수 없습니다.");
        }
    }

    public void move() {
        this.position++;
    }

    public Position calBiggerPosition(Position compare) {
        return this.position > compare.position ? this : compare;
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
