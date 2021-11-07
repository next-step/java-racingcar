package step3.domain.car;

import step3.domain.board.RoundBoard;

import java.util.Objects;

import static step3.utils.ValidationUtils.checkArgument;

public class Location {

    private static final int DEFAULT_INTERVAL = 1;
    private static final int MIN_POSITIVE_VALUE = 1;

    private final int interval;

    private int location;

    public static Location placeOn(Integer location) {
        return new Location(location, DEFAULT_INTERVAL);
    }

    public static Location placeOn(Integer location, Integer interval) {
        return new Location(location, interval);
    }

    private Location(Integer location, Integer interval) {
        checkArgument(location != null, "location is required");
        checkPositive(interval);
        this.location = location;
        this.interval = interval;
    }

    private void checkPositive(Integer interval) {
        if (interval == null || interval < MIN_POSITIVE_VALUE) {
            throw new IllegalArgumentException("interval is not Positive");
        }
    }

    public void goForward() {
        location += interval;
    }

    public void record(RoundBoard roundBoard) {
        roundBoard.record(location);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location1 = (Location) o;
        return location == location1.location;
    }

    @Override
    public int hashCode() {
        return Objects.hash(location);
    }

    @Override
    public String toString() {
        return "Location{" +
                "location=" + location +
                '}';
    }
}
