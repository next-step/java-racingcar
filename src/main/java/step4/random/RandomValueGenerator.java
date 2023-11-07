package step4.random;

import java.util.Random;

public class RandomValueGenerator {
    private static final Random RANDOM = new Random();

    public static int generateRandomValueFromZeroToNine() {
        return RANDOM.nextInt(10);
    }
}
