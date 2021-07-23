package racing.car;

public class Location {
    public static Location EMPTY = new Location();
    public static Location ONE_BLOCK = new Location(1);
    private final int value;

    public Location() {
        this(0);
    }

    public Location(int location) {
        this.value = location;
    }

    public int getValue() {
        return value;
    }

    public Location add(Location location) {
        return new Location(
                this.getValue() + location.getValue()
        );
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Location))
            return false;
        Location compareLocation = (Location) obj;
        return this.getValue() == compareLocation.getValue();
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
