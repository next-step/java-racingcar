import java.util.Random;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private int currentLocation;

    Car() {
        this.currentLocation = 0;
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
