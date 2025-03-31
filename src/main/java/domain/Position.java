package domain;

import view.PositionFormatter;

public class Position {
    public static final Position ZERO = new Position(0);
    private final Integer position;

    public Position(Integer position) {
        this.position = position;
    }

    public Position add(Integer distance) {
        return new Position(this.position + distance);
    }

    public Position add(Position position) {
        return position.add(this.position);
    }

    public Position copy() {
        return new Position(this.position);
    }

    public boolean isAheadOf(Position position) {
        return position.isSamePositionWith(this.position) || position.isLessThan(this.position);
    }

    public boolean isSamePositionWith(Integer position) {
        return this.position.equals(position);
    }

    public boolean isLessThan(Integer position) {
        return this.position < position;
    }

    public PositionFormatter generateFormatter() {
        return new PositionFormatter(this.position);
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
