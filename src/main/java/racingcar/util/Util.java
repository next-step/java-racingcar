package racingcar.util;

import java.util.Random;

public class Util {
    private static Random random = new Random();

    public static int generateRandom() {
        return random.nextInt(10);
    }
}
