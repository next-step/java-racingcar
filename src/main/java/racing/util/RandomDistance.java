package racing.util;

import java.util.Random;

public class RandomDistance {
    private static final int RANDOM_RANGE = 10;
    private static final int MOVABLE_NUMBER = 4;

    private static final Random RANDOM_GENERATOR = new Random();

    public static int getMoveDistance() {
        final int randomNumber = RANDOM_GENERATOR.nextInt(RANDOM_RANGE);
        return (randomNumber >= MOVABLE_NUMBER) ? 1 : 0;
    }
}
