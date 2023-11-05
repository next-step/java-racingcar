package step3.random;

import java.util.Random;

public class RandomValueGenerator {
    private static final Random random = new Random();

    public static int generateRandomValueFromZeroToNine() {
        return random.nextInt(10);
    }
}
