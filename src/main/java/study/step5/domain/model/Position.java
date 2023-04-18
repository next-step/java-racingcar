package study.step5.domain.model;

import java.util.Objects;

public class Position {
    private int position = 0;

    public int getPosition() {
        return position;
    }

    public void increase() {
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
