package racingcar;

import java.util.Random;

public class RandomNumberMover implements CarMover {
    private static final int RANDOM_BOUND = 10;
    private static final int MOVABLE_LIMIT_NUMBER = 4;

    private Random random = new Random();

    @Override
    public boolean movable() {
        return random.nextInt(RANDOM_BOUND) >= MOVABLE_LIMIT_NUMBER;
    }
}
