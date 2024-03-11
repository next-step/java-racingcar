package model;

import java.util.Objects;

public class RacingCar {

    private static final int MOVE_THRESHOLD = 4;

    private final Location location;
    private final Name name;

    public RacingCar(final Name name) {
        this(new Location(0), name);
    }

    public RacingCar(final Location location, final Name name) {
        this.location = location;
        this.name = name;
    }

    public void move(final int randomNumber) {
        if (randomNumber >= MOVE_THRESHOLD) {
            location.increase();
        }
    }

    public Location getGreaterLocation(final Location maxLocation) {
        if (location.isGreaterThan(maxLocation)) {
            return location;
        }
        return maxLocation;
    }

    public boolean isSameLocation(final Location maxLocation) {
        return location.equals(maxLocation);
    }

    public int getLocationValue() {
        return location.getValue();
    }

    public Name getName() {
        return name;
    }

    public String getNameValue() {
        return name.getName();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final RacingCar racingCar = (RacingCar) o;
        return Objects.equals(location, racingCar.location) && Objects.equals(getName(),
                racingCar.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, getName());
    }
}
