package step4.domain;

import java.util.Objects;

public class Position {
    private int position;

    public Position() { }

    public Position(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("위치값은 음수를 가질 수 없습니다.");
        }
        this.position = position;
    }

    public void increase() {
        this.position++;
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
