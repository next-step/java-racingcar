package step5.model;

public class Position implements Comparable<Position>{

    private final int position;

    public Position(int position) {
        validate(position);
        this.position = position;
    }

    private void validate(int position) {
        if (position < 0) {
            throw new InvalidPositionException("위치는 0보다 작을 수 없습니다");
        }
    }

    public int getPosition() {
        return position;
    }

    public Position increase() {
        return new Position(position + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !o.getClass().equals(Position.class)) {
            return false;
        }
        Position other = (Position) o;
        return this.position == other.position;
    }

    @Override
    public int compareTo(Position other) {
        return this.position - other.position;
    }
}
