package carrace.movement.car;

import carrace.movement.Move;

public class CarMovement implements Move {

    private static final int MOVE_CONDITION = 4;
    private static final int LOWER_BOUND = 0;
    private static final int UPPER_BOUND = 9;

    private int position = 1;

    public void moveForward() {
        this.position = this.position + 1;
    }

    public int get() {
        return position;
    }

    public void checkAndMoveForward(int randomValue) {
        if (randomValue < LOWER_BOUND || randomValue > UPPER_BOUND) {
            throw new RuntimeException("랜덤 값은 0에서 9사이의 값이어야합니다.");
        }

        if (randomValue >= MOVE_CONDITION) {
            moveForward();
        }
    }
}
