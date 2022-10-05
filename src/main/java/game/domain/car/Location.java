package game.domain.car;

import java.util.Objects;

public class Location {

    public static int LOCATION_MINIMUM = 0;
    public static String LOCATION_EXCEPTION = "Location은 음수일 수 없습니다.";
    public int location;

    public Location(int location) {
        if (location < LOCATION_MINIMUM) {
            throw new IllegalArgumentException(LOCATION_EXCEPTION);
        }
        this.location = location;
    }

    public Location(Location location) {
        this(location.getLocation());
    }

    public Location() {
        this(LOCATION_MINIMUM);
    }

    public int getLocation() {
        return this.location;
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

    public void forward(int number) {
        this.location += number;
    }
}
