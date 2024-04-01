package racing.service;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator{

    private static final int RANDOM_INT_MAX_LIMIT = 10;
    private static final Random random = new Random();
    public Integer getNumber() {
        return random.nextInt(RANDOM_INT_MAX_LIMIT);
    }
}
