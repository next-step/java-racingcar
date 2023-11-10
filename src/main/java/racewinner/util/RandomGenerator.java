package racewinner.util;

import java.util.Random;

public class RandomGenerator {
    private final static int MAX_NUMBER = 10;
    public int number() {
        return new Random().nextInt(MAX_NUMBER);
    }
}
