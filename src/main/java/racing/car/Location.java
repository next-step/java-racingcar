package racing.car;

public class Location {
    private static final String UNDER_LOCATION_MESSAGE = "연료는 음수르 충전할 수 없습니다.";

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
        validate(value);
        return value;
    }

    private static void validate(int value) {
        if (value < 0)
            throw new IllegalArgumentException(UNDER_LOCATION_MESSAGE);
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
        if (obj instanceof Location) {
            Location compareLocation = (Location) obj;
            return this.getValue() == compareLocation.getValue();
        }
        return false;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
