package racing.domain;

import java.util.Objects;

public class Position {

    private int position;

    public Position(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("Position 은 음수 값을 가질 수 없습니다");
        }
        this.position = position;
    }

    public Position move() {
        position += 1;
        return this;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (!(o instanceof Position)) { return false; }
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
