package racinggame;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    private static int RANDOM_BOUND = 10;
    private static int THRESHOLD = 4;

    public boolean canMove() {
        int randomNumber = new Random().nextInt(RANDOM_BOUND);
        return randomNumber >= THRESHOLD;
    }
}
