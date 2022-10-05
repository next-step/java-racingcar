package racingcar.domain;

import java.util.Objects;

public class Location {
    public static final int MINIMUM_VALUE = 0;

    private final int location;

    public Location() {
        this.location = MINIMUM_VALUE;
    }

    public Location(int location) {
        validateLocationOverMinimum(location);
        this.location = location;
    }

    private void validateLocationOverMinimum(int location) {
        if (location < MINIMUM_VALUE) {
            throw new IllegalArgumentException("위치는 0보다 작을 수 없습니다.");
        }
    }

    public Location next() {
        return new Location(location + 1);
    }

    public int getLocation() {
        return location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location1 = (Location) o;
        return location == location1.location;
    }

    @Override
    public int hashCode() {
        return Objects.hash(location);
    }
}
