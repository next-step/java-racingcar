package utils;

import java.util.Random;

public class RandomNumberGenerator {
    private final static Random random = new Random();

    public static int generate() {
        return random.nextInt(10);
    }
}
