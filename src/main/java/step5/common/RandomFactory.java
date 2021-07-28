package step5.common;

import java.util.Random;

public class RandomFactory {
    private static Random random = new Random();

    public static int getRandomNumber(int RANDOM_BOUNDARY) {
        return random.nextInt(RANDOM_BOUNDARY);
    }
}
