package racinggame.domain.random;

import java.util.Random;

public class RandomGenerator implements RandomRule {

    private static final Random random = new Random();
    private static final int LIMIT = 10;

    @Override
    public int getRandomValue() {
        return random.nextInt(LIMIT);
    }
}
