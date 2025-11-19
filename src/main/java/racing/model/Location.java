package racing.model;

import java.util.Objects;

public class Location {
    private int position;

    public Location() {
        this(0);
    }

    public Location(int position) {
        if (!isValid(position)) {
            throw new IllegalArgumentException("Location은 0 이상의 값이어야 합니다.");
        }
        this.position = position;
    }

    public void moveForward() {
        this.position++;
    }

    public String toString(String symbol) {
        return symbol.repeat(this.position);
    }

    public Location max(Location compareTo) {
        if (this.position >= compareTo.position) {
            return this;
        }
        return compareTo;
    }

    private boolean isValid(int position) {
        return position >= 0;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return position == location.position;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(position);
    }
}
