package race;

import java.util.Objects;

public class Position {
    private int position = 0;

    public void add() {
        position++;
    }

    public int get() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (position == (int) o) return true;
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
