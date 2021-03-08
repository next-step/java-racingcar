package racingcar.domain;

public class Car {
    private static final int INIT_VALUE = 0;
    private static final int CONDITION_FOR_MOVEMENT = 4;
    private int movementRange;

    public Car() {
        movementRange = INIT_VALUE;
    }

    public void move(int number) {
        if (number >= CONDITION_FOR_MOVEMENT) {
            movementRange++;
        }
    }

    public int getMovementRange() {
        return movementRange;
    }
}
