package racingcar;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private static final int MAX_NUMBER = 10;

    public int generate() {
        Random random = new Random();
        return random.nextInt(MAX_NUMBER);
    }
}
