package step3;

import java.util.Random;

public class RandomMoveStrategy {
    private static int RANDOM_BOUND = 10;
    private static int THRESHOLD = 4;

    public boolean canMove() {
        return new Random().nextInt(RANDOM_BOUND) >= THRESHOLD;
    }
}
