package game.domain.car;

import java.util.Objects;

public class Location {

    public int location;
    public Location(int location) {
        this.location = location;
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
