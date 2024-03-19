package racing.domain;

public class CurrentLocation {
    private static final int MOVABLE_LOWER_BOUND = 4;
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

    public void move(int movePoint) {
        if (isMove(movePoint)) {
            currentLocation++;
        }
    }

    private boolean isMove(int movePoint) {
        return movePoint >= MOVABLE_LOWER_BOUND;
    }

    public boolean isSameLocation(int location) {
        return this.currentLocation == location;
    }
}
