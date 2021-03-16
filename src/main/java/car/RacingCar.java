package car;

import java.util.Random;

public class RacingCar {
    private final Random random = new Random();
    private int moveCount;


    public void tryMoving() {
        if (canMove()) {
            moveCount++;
        }
    }

    private boolean canMove() {
        return random.nextInt(10) >= CarRacingGame.MOVE_THRESHOLD;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
