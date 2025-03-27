package domain;

public class Position {
    private final Integer position;

    public Position(Integer position) {
        this.position = position;
    }

    public Integer value() {
        return this.position;
    }

    public Position add(Integer distance) {
        return new Position(this.position + distance);
    }

    public Position copy() {
        return new Position(this.position);
    }

    public boolean isAheadOf(Position position) {
        return this.position > position.value();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Position)) {
            return false;
        }

        return this.position.equals(((Position) obj).position);
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(this.position);
    }
}
