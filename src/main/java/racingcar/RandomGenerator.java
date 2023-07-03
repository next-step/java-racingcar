package racingcar;

import java.util.Random;

public class RandomGenerator {
    static final int min = 0;
    static final int max = 9;
    static final Random random = new Random();
    public static int generateNumber() {
        return random.nextInt(max + min) + min;
    }
}
