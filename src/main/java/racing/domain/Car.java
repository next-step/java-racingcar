package racing.domain;

public class Car {
    private static final int DEFAULT_POSITION = 1;
    private int position;

    public Car() {
        position = DEFAULT_POSITION;
    }

    public Car setPosition(int inputPosition) {
        position = inputPosition;
        return this;
    }

    public int moveByCondition(int condition) {
        if (Movable.isMovable(condition)) {
            return moveForward();
        }

        return getPosition();
    }

    private int moveForward() {
        return ++position;
    }

    public int getPosition() {
        return position;
    }
}
