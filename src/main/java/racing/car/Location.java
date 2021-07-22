package racing.car;

public class Location {
    public static Location EMPTY = new Location();
    private static final char VALUE_UNIT = '-';
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

    public Location min(Location location) {
        return new Location(getValue() - location.getValue());
    }

    public boolean hasValue() {
        return getValue() > 0;
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
        if (this.value != compareLocation.value)
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(VALUE_UNIT); // 위치가 0 이어도 - 표시가 필요함
        for (int i = 0; i < value; i++)
            builder.append(VALUE_UNIT);
        return builder.toString();
    }
}
