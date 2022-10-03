package racing.model;

import java.util.Objects;

public class CurrentLocation implements Comparable<CurrentLocation> {

    private static final String MINUS_LOCATION_ERROR_MESSAGE = "자동차의 거리를 음수로 설정할 수 없습니다. 현재 거리 설정값 : ";
    private static final int MIN_LOCATION = 0;
    private static final int ONE_GO_STRAIGHT = 1;

    private final int currentLocation;

    public CurrentLocation(int startLocation) {
        validateLocation(startLocation);
        this.currentLocation = startLocation;
    }

    public CurrentLocation goStraight() {
        return new CurrentLocation(this.currentLocation + ONE_GO_STRAIGHT);
    }

    public int getCurrentLocation() {
        return this.currentLocation;
    }

    private void validateLocation(int startLocation) {
        if (startLocation < MIN_LOCATION) {
            throw new IllegalArgumentException(MINUS_LOCATION_ERROR_MESSAGE + startLocation);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CurrentLocation)) return false;
        CurrentLocation that = (CurrentLocation) o;
        return currentLocation == that.currentLocation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentLocation);
    }

    @Override
    public int compareTo(CurrentLocation o) {
        return Integer.compare(this.currentLocation, o.currentLocation);
    }
}
