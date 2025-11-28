package model;

public class Position implements Comparable<Position> {
    private int position;

    public Position(int position) {
        this.position = position;
    }

    public void forward() {
        position++;
    }

    public Position max(Position other) {
        return this.compareTo(other) >= 0 ? this : other;
    }

    @Override
    public int compareTo(Position o) {
        return Integer.compare(this.position, o.position);
    }

    @Override
    public String toString() {
        return "-".repeat(position);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }
}
