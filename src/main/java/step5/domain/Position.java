package step5.domain;

import java.util.Objects;

public class Position {

    private int position;

    public Position() {
        this(0);
    }

    public Position(int position) {
        validatePositiveInput(position);
        this.position = position;
    }

    private void validatePositiveInput(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("자동차 전진 수는 음수값이 될 수 없습니다.");
        }
    }

    public void move() {
        position = position + 1;
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
