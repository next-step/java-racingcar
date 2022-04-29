package carrace.domain;

public class Position {

    private final int position;
    public Position(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("음수 값의 Position 은 존재할 수 없습니다.");
        }

        this.position = position;
    }

    public Position add(int moved) {
        return new Position(position + moved);
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
        return position;
    }
}
