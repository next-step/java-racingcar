package step4;

import java.util.Objects;

public class Location {
    private final int position;

    public Location(int position) {
        this.position = position;
    }

    public Location increaseLocation() {
        return new Location(this.position + 1);
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location1 = (Location) o;
        return position == location1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
