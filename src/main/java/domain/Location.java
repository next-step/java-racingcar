package domain;

import java.util.Objects;

public class Location {
    private static final int INITIAL_LOCATION = 0;
    private int location;

    public Location() {
        this(INITIAL_LOCATION);
    }

    public Location(int location) {
        validateLocation(location);
        this.location = location;
    }

    private void validateLocation(int location) {
        if (location <= -1) {
            throw new IllegalArgumentException("음수는 사용할 수 없습니다.");
        }
    }

    int getLocation() {
        return location;
    }

    public void moveToForward() {
        this.location++;
    }

    public Location max(Location location, Location maxLocation) {
        return location.location >= maxLocation.location ? location : maxLocation;
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
