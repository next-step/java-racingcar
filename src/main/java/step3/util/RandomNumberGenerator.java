package step3.util;

import java.util.Random;

public class RandomNumberGenerator {

    private RandomNumberGenerator() {}

    public static int generate() {
        Random generator = new Random();

        return generator.nextInt(10);
    }
}
