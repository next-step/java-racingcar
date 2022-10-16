package step4;

import java.util.Objects;

public class Location {
    private static final int ADVANCE_RANDOM_NUMBER = 4;
    private final int position;

    public Location() {
        this.position = 0;
    }

    public Location(int position) {
        this.position = position;
    }

    public Location move(int randomNumber) {
        if (isMovable(randomNumber)) {
            return new Location(this.position + 1);
        }
        return new Location(this.position);
    }

    private boolean isMovable(int randomNumber) {
        return randomNumber >= ADVANCE_RANDOM_NUMBER;
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
