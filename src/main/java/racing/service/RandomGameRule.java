package racing.util;

import java.util.Random;

public class RandomInt {

    private static final int RANDOM_INT_MAX = 10;
    private static final int POSSIBLE_INT = 4;

    private static int makeRandomInt() {
        Random random = new Random();
        return random.nextInt(RANDOM_INT_MAX);
    }
    public static int getPossibleInt() {
        return (POSSIBLE_INT <= makeRandomInt()) ? 1 : 0;
    }
}
