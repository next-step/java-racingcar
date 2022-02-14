package racingcar.domain;

import java.util.Random;

public class RandomGenerate {

    private static final int MAX_NUMBER = 9;
    private static final Random random = new Random();

    public static int makeRandom() {
        return random.nextInt(MAX_NUMBER);
    }
}
