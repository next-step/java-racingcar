package racingcar.utils;

import java.util.Random;

public class RandomNumberUtil {

    private static Random random = null;

    public static int getRandomNumber(int bound) {
        if (random == null) {
            random = new Random();
        }

        return random.nextInt(bound);
    }

}
