package racinggame;

import java.util.Random;

public class RacingRandomGenerator implements RandomGenerator {

    private final Random random = new Random();

    @Override
    public int nextInt() {
        return random.nextInt(10);
    }
}
