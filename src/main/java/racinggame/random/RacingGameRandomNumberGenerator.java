package racinggame.random;

import java.util.Random;

public class RacingGameRandomNumberGenerator implements RandomNumberGenerator {
    private static final int MAX_RANDOM_VALUE = 10;

    @Override
    public int generate() {
        return new Random().nextInt(MAX_RANDOM_VALUE);
    }
}
