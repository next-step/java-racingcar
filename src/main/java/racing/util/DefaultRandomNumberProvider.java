package racing.util;

import java.util.Random;

public class DefaultRandomNumberProvider implements RandomNumberProvider {
    private static final int RANDOM_BOUND_NUMBER = 10;
    private static final Random RANDOM = new Random();

    @Override
    public int getRandomNumber() {
        return RANDOM.nextInt(RANDOM_BOUND_NUMBER);
    }
}
