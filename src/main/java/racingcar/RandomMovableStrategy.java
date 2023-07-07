package racingcar;

import java.util.Random;

public final class RandomMovableStrategy implements MovableStrategy {

    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 10;

    public int generate() {
        final Random random = new Random();
        return random.nextInt(MAX_NUMBER - MIN_NUMBER);
    }
}
