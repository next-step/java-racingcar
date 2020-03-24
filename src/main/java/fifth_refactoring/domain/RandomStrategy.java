package fifth_refactoring.domain;

import java.util.Random;

public class RandomStrategy implements Strategy {
    private static final int ALLOW_MOVE_NUMBER = 4;
    private static final int RANDOM_MAX_NUMBER = 9;
    private static final int RANDOM_MIN_NUMBER = 0;

    public boolean move() {
        return new Random().nextInt(RANDOM_MAX_NUMBER + 1) + RANDOM_MIN_NUMBER > ALLOW_MOVE_NUMBER;
    }
}
