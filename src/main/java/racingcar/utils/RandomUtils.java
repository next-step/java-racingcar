package racingcar.utils;

import java.util.Random;

public class RandomUtils {
    private RandomUtils() {
    }

    public static int nextInt(final int from, final int to) {
        return new Random().nextInt(from + to) - from + 1;
    }
}
