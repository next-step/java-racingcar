package step3.generator;

import java.util.Random;

public class RandomGenerator {
    private static final Random rand = new Random();

    public static int generateValue() {
        return rand.nextInt(10);
    }

}
