package racing.domain;

public class Location {
    private static final String UNDER_LOCATION_MESSAGE = "연료는 음수르 충전할 수 없습니다.";

    private static final Object syncObject = new Object();
    private static final int MIN_VALUE = 0;
    private static final int ONE_BLOCK_VALUE = 1;
    public static Location empty;
    public static Location oneBlock;
    private final int value;

    public Location() {
        this(0);
    }

    public Location(int location) {
        validate(location);
        this.value = location;
    }

    public int value() {
        return value;
    }

    public static Location empty() {
        if (empty == null) {
            synchronized (syncObject) {
                if (empty == null)
                    empty = new Location(MIN_VALUE);
            }
        }
        return empty;
    }

    public static Location oneBlock() {
        if (oneBlock == null) {
            synchronized (syncObject) {
                if (oneBlock == null)
                    oneBlock = new Location(ONE_BLOCK_VALUE);
            }
        }
        return oneBlock;
    }

    private static void validate(int value) {
        if (value < MIN_VALUE)
            throw new IllegalArgumentException(UNDER_LOCATION_MESSAGE);
    }

    public Location add(Location location) {
        return new Location(
                this.value() + location.value()
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
            return this.value() == compareLocation.value();
        }
        return false;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
