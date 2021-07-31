package racingcar.utils;

import java.util.Random;

public class RandomGenerate {

    private static final Random RANDOM = new Random();

    private RandomGenerate() {
    }

    public static int pickRandomNumber(int bound) {
        return RANDOM.nextInt(bound);
    }

}
