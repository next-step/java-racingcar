package racingcar.domain;

import java.util.Random;

public class RandomGenerator {
    static final int MIN = 0;
    static final int MAX = 9;
    static final Random random = new Random();

    public static int generateNumber() {
        return random.nextInt(MAX + MIN) + MIN;
    }
}
