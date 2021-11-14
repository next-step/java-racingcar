package step3.domain.value;

import java.util.Objects;

public class Location {
    private final String carName;
    private final int value;

    public Location(String carName, int value) {
        this.carName = carName;
        this.value = value;
    }

    public Location forward() {
        return new Location(carName, value + 1);
    }

    public String getCarName() {
        return carName;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return value == location.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
