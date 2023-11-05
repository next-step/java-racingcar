package racingCar;

public class Car {
    private int currentPosition = 0;

    public static final int MOVE_DISTANCE = 1;

    public void moveForward() {
        currentPosition += MOVE_DISTANCE;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }
}
