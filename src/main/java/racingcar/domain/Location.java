package racingcar.domain;

import javafx.fxml.LoadException;

import java.util.Objects;

public class Location {
    static final int MIN_LOCATION_VALUE = 0;
    private final int location;

    Location(int location) {
        validateLocation(location);
        this.location = location;
    }

    private void validateLocation(int location) {
        if (location < MIN_LOCATION_VALUE) {
            throw new IllegalArgumentException("유효한 location 값이 아닙니다.");
        }
    }

    public Location goForward() {
        return new Location(location + 1);
    }

    public int compareTo(Location location1) {
        return location1.location - location;
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

    @Override
    public String toString() {
        StringBuilder locStr = new StringBuilder(location);

        for (int i = 0; i < location; i++) {
            locStr.append("-");
        }

        return locStr.toString();
    }
}
