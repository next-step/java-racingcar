package car;

import java.util.Random;

public class RacingCar {
    public static final int MOVE_THRESHOLD = 4;

    private final Random random = new Random();
    private int moveCount;

    public void tryMoving() {
        if (canMove()) {
            moveCount++;
        }
    }

    private boolean canMove() {
        return random.nextInt(10) >= MOVE_THRESHOLD;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
