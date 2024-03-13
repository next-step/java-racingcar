package racing;

public class Car {
    private static final int MOVABLE_LOWER_BOUND = 4;
    private static final int DEFAULT_START_LOCATION = 0;

    private final String name;
    private int currentLocation;

    public int getCurrentLocation() {
        return currentLocation;
    }

    public String getName() {
        return name;
    }

    public Car(String name, int currentLocation) {
        this.name = name;
        this.currentLocation = currentLocation;
    }

    public Car(String name) {
        this.name = name;
        this.currentLocation = DEFAULT_START_LOCATION;
    }

    public void move(int movePoint) {
        if (isMove(movePoint)) {
            currentLocation++;
        }
    }

    private static boolean isMove(int movePoint) {
        return movePoint >= MOVABLE_LOWER_BOUND;
    }
}
