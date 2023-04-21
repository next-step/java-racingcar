package race;

import java.util.Comparator;
import java.util.Objects;

public class Position {
    private int position = 0;

    public void moveForward() {
        position++;
    }

    public int getPosition() {
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

    public static Comparator<Position> getComparator() {
        return Comparator.comparingInt(Position::getPosition);
    }
}
