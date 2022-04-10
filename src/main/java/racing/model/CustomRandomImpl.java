package racing.model;

import java.util.Random;

public class CustomRandomImpl implements CustomRandom {
    private static final int MINIMUM_BOUND = 0;
    private static final String EXCEPTION_MESSAGE = "1이상 입력하세요.";

    private final Random random = new Random();

    @Override
    public int getRandomRange(int bound) {
        if (bound <= MINIMUM_BOUND) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
        return random.nextInt(bound);
    }
}
