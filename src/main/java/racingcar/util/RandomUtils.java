package racingcar.util;

import java.util.Random;

public class RandomUtils {

    private static Random random = new Random();

    public int getInt(int limit) {
        return random.nextInt(limit);
    }
}
