package racingcargame.domain;

import java.util.Random;

public class RandomNumberOption implements RandomOption {
    private static final Random RANDOM = new Random();
    private static final int LIMIT_NUMBER = 10;

    @Override
    public int randomValue() {
        return RANDOM.nextInt(LIMIT_NUMBER);
    }
}
