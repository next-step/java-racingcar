package racing.car;

import java.util.Random;

public class RandomMovement implements Movement {

    private static final Random RANDOM = new Random();
    private static final int RANDOM_BOUND = 10;
    private static final int MOVE_THRESHOLD = 4;

    @Override
    public int move() {
        return RANDOM.nextInt(RANDOM_BOUND) < MOVE_THRESHOLD ? 0 : 1;
    }
}
