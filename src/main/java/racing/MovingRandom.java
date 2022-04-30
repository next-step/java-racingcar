package racing;

import java.util.Random;

public class MovingRandom implements Moving {
    private static final int MAX_BOUND = 10;
    private static final int CRITERION_VALUE = 4;
    private static final int MOVE = 1;
    private static final int NOT_MOVE = 0;

    private static final Random random = new Random();

    @Override
    public int move() {
        if (random.nextInt(MAX_BOUND) >= CRITERION_VALUE) {
            return MOVE;
        }
        return NOT_MOVE;
    }
}
