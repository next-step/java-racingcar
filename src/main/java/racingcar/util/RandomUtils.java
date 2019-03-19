package racingcar.util;

import java.util.Random;

public class RandomUtils {
    private static final Random RANDOM = new Random();

    public static int getRandomNumber(int bits) {
        return RANDOM.nextInt(bits);
    }
}