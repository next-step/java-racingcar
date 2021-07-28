package step5.common;

import java.util.Random;

public class RandomFactory {
    private static final int RANDOM_BOUNDARY = 10;
    private static Random random = new Random();

    public static int getRandomNumber() {
        return random.nextInt(RANDOM_BOUNDARY);
    }
}
