package racingcar.util;

import java.util.Random;

public class NumberGenerator {

    private static Random random = new Random();

    public static int generator() {
        return random.nextInt(10);
    }
}
