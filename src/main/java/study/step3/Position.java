package study.step3;

import java.util.Objects;

public class Position implements Comparable<Position>{

    private int position;

    public Position(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void increase() {
        this.position++;
    }

    public boolean isBigger(Position position) {
        return compareTo(position) > 0;
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

    @Override
    public int compareTo(Position o) {
        return Integer.compare(this.position, o.position);
    }

}
