package util;

import java.util.Random;

public class RandomNumberGenerator {
    private final static Random random = new Random();

    public static int random() {
        return random.nextInt(10);
    }
}