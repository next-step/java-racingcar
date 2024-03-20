package racing.domain;

public class CurrentLocation {
    private static final int DEFAULT_START_LOCATION = 0;

    private int currentLocation;

    public CurrentLocation() {
        this(DEFAULT_START_LOCATION);
    }

    public CurrentLocation(int currentLocation) {
        this.currentLocation = currentLocation;
    }

    public int getCurrentLocation() {
        return currentLocation;
    }

    public void moveForward() {
        currentLocation++;
    }

    public boolean isSameLocation(int location) {
        return this.currentLocation == location;
    }
}
