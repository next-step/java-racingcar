package racingcar.util;

import java.util.Random;

public class RandomGenerator {

    private final Random random = new Random();

    public int generateNumber(int bound) {
        return random.nextInt(bound);
    }
}
