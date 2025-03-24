package racing.domain;

public class Position {
    private static final int INIT_POSITION = 1;
    private final int value;

    public Position() {
        this.value = INIT_POSITION;
    }

    public Position(int value) {
        this.value = value;
    }

    public Position increasePosition() {
        return new Position(this.value + 1);
    }

    public Position betterThan(Position otherPosition) {
        if (this.value > otherPosition.value) {
            return this;
        }
        return new Position(otherPosition.value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Position position = (Position) obj;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
