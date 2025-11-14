import java.util.Objects;

public class Location {
    private int position;

    Location() {
        this(0);
    }

    Location(int position) {
        if (!isValid(position)) {
            throw new IllegalArgumentException("Location은 0 이상의 값이어야 합니다.");
        }
        this.position = position;
    }

    void moveForward() {
        this.position++;
    }

    String toString(String symbol) {
        return symbol.repeat(this.position);
    }

    public static Location max(Location location1, Location location2) {
        if (location1.position >= location2.position) {
            return location1;
        }
        return location2;
    }

    private static boolean isValid(int position) {
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
