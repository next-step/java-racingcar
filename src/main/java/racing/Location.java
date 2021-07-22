package racing;

import java.util.Objects;

public class Location {
    private static final char VALUE_UNIT = '-';
    private int value = 0;

    public Location() {
        this(0);
    }

    public Location(int location) {
        this.value = location;
    }

    public int getValue() {
        return value;
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
        for (int i = 0; i < value; i++)
            builder.append(VALUE_UNIT);
        return builder.toString();
    }
}
