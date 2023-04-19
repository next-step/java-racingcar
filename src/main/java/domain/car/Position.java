package domain.car;

public class Position implements Comparable<Position> {
    private static final int DEFAULT_POSITION = 0;

    private int position;

    public Position() {
        this(DEFAULT_POSITION);
    }

    public Position(int position) {
        this.position = position;
    }

    public void move() {
        this.position++;
    }

    public int intValue() {
        return this.position;
    }

    @Override
    public int compareTo(Position o) {
        return position - o.intValue();
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
        return position;
    }
}
