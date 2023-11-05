package racingCar;

public class Car {
    private int currentPosition = 0;

    //한번에 이동하는 거리
    public static final int MOVE_DISTANCE = 1;

    //이동조건
    public static final int MOVE_CONDITION = 4;

    public void moveForward() {
        currentPosition += MOVE_DISTANCE;
    }

    public void moveAttempt(int value) {
        if (movable(value)) {
            moveForward();
        }
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    private boolean movable(int value) {
        if (value < MOVE_CONDITION) {
            return false;
        }
        return true;
    }
}
