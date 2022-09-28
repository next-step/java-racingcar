package racingcarGame.util;

import java.util.Random;

public class RandomNumber {
    private static final Random random = new Random();
    private static final int MAX = 10;

    public static int generate() {
        return random.nextInt(MAX);
    }
}
