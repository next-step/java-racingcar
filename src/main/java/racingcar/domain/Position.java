package racingcar.domain;

import java.util.Objects;

public class Position implements Cloneable, Comparable<Position> {

    private int position;

    public Position() {
        this(0);
    }

    public Position(int value) {
        this.position = value;
    }

    public void forward() {
        this.position += 1;
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
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i=0 ; i<position ; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public int compareTo(Position o) {
        if (this.position > o.position) {
            return 1;
        }
        return -1;
    }
}
