public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private final String name;
    private int currentLocation;

    Car(String name) {
        this(name, 0);
    }

    Car(String name, int currentLocation) {
        if (!isValidName(name)) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }
        this.name = name;
        this.currentLocation = currentLocation;
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

    int getMaxLocation(int maxLocation) {
        return Math.max(this.currentLocation, maxLocation);
    }

    boolean isAtLocation(int targetLocation) {
        return this.currentLocation == targetLocation;
    }

    private boolean isMovable(int number) {
        return number >= MOVE_THRESHOLD;
    }

    private void moveForward() {
        currentLocation++;
    }

    private boolean isValidName(String name) {
        return name.length() <= 5;
    }
}
