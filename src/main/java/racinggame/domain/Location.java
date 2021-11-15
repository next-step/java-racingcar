package racinggame.domain;

import java.util.Objects;

public class Location implements Comparable<Location> {
    public static final int START_LOCATION = 0;

    private int location;

    public Location() {
        this(START_LOCATION);
    }

    public Location(int location) {
        this.location = location;
    }

    public int getLocation() {
        return location;
    }

    public void move() {
        location++;
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
    public int compareTo(Location o) {
        if (this.getLocation() > o.getLocation()) {
            return 1;
        }
        if (this.getLocation() == o.getLocation()) {
            return 0;
        }
        return -1;
    }

    public Location compareToLocation(Location o) {
        if (o.compareTo(this) == 1) {
            return o;
        }
        return this;
    }
}
