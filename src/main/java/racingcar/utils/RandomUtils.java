package racingcar.utils;

import java.util.Random;

public class RandomUtils {
    private static final Random RANDOM = new Random();

    public static int getRandomPositiveInt(int max) {
        return RANDOM.nextInt(max + 1);
    }
}
