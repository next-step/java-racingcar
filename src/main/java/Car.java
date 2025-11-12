public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private final String name;
    private int currentLocation;

    Car(String name) {
        this.name = name;
        this.currentLocation = 0;
    }

    String name() {
        return name;
    }

    int currentLocation() {
        return currentLocation;
    }

    void makeMove(int number) {
        if (isMovable(number)) {
            moveForward();
        }
    }

    private boolean isMovable(int number) {
        return number >= MOVE_THRESHOLD;
    }

    private void moveForward() {
        currentLocation++;
    }
}
