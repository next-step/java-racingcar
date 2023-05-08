package racingcar.domain.car;

public class Position {
    private final static int DEFAULT_LOCATION = 0;

    private final int location;

    public Position(int location) {
        if (location < DEFAULT_LOCATION) {
            throw new IllegalArgumentException("위치는 0보다 작을 수 없습니다.");
        }
        this.location = location;
    }

    public Position() {
        this(DEFAULT_LOCATION);
    }

    public boolean isGreaterThan(Position location) {
        return this.location >= location.value();
    }

    public Position max(Position criteria) {
        return new Position(Math.max(this.location, criteria.value()));
    }

    public Position move() {
        return new Position(this.location + 1);
    }

    public int value() {
        return this.location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;

        Position position = (Position) o;

        return location == position.location;
    }

    @Override
    public int hashCode() {
        return location;
    }
}
