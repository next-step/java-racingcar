package racing.domain;

import exception.CarLocationException;

import java.util.Objects;

public class Location {
    private final Integer location;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;

        Location location1 = (Location) o;

        return Objects.equals(location, location1.location);
    }

    @Override
    public int hashCode() {
        return location != null ? location.hashCode() : 0;
    }

    public Location(Integer location) {
        try {
            validate(location);
        } catch (CarLocationException e) {
            throw new RuntimeException(e);
        }
        this.location = location;
    }

    public Integer value() {
        return this.location;
    }

    public Location move(Integer moveAmount) throws CarLocationException {
        Integer newLocation = this.location + moveAmount;
        return new Location(newLocation);
    }

    private void validate(Integer location) throws CarLocationException {
        if (location < 0) {
            throw new CarLocationException("음수로는 이동할 수 없습니다.");
        }
        if (location > Integer.MAX_VALUE) {
            throw new CarLocationException("최대 이동할 수 있는 범위를 넘을 수 없습니다.");
        }
    }
}
