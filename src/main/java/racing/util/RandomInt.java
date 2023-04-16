package racing.util;

import java.util.Random;

public class RandomInt {

    private static final int RANDOM_INT_MAX = 8;
    private static final int POSSIBLE_INT = 4;

    private static int makeRandomInt() {
        Random random = new Random();
        return random.nextInt(RANDOM_INT_MAX);
    }
    public static int getPossibleInt() {
        int randomInt = makeRandomInt();
        if (randomInt < POSSIBLE_INT)
            randomInt = 0;
        return randomInt;
    }
}
