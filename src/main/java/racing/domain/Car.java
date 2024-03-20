package racing.domain;

public class Car {
    private static final int MOVABLE_LOWER_BOUND = 4;
    private final Name name;
    private final CurrentLocation currentLocation;

    public Car(String name, int currentLocation) {
        this.name = new Name(name);
        this.currentLocation = new CurrentLocation(currentLocation);
    }

    public Car(String name) {
        this.name = new Name(name);
        this.currentLocation = new CurrentLocation();
    }

    public int getCurrentLocation() {
        return this.currentLocation.getCurrentLocation();
    }

    public String getName() {
        return this.name.getName();
    }

    public void move(int movePoint) {
        if (isMove(movePoint)) {
            this.currentLocation.moveForward();
        }
    }

    private boolean isMove(int movePoint) {
        return movePoint >= MOVABLE_LOWER_BOUND;
    }

    public boolean isSameLocation(int location) {
        return this.currentLocation.isSameLocation(location);
    }
}
