package racingcar.model;

public class Car {
    private static final int MOVE_STANDARD = 4;
    private static final int MOVE_DISTANCE = 1;

    private int distance = 0;

    public int getDistance() {
        return this.distance;
    }

    public void move(int movableNumber) {
        if (movableNumber >= MOVE_STANDARD) {
            distance += MOVE_DISTANCE;
        }
    }
}
