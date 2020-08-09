package step3.generator;

import java.util.Random;

public class RandomGenerator {
    private static final Random RAND = new Random();

    public static int generateValue(int value) {
        return RAND.nextInt(value);
    }

}
