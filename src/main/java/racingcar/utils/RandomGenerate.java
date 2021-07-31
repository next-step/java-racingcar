package racingcar.utils;

import java.util.Random;

public class RandomGenerate {

    private static final int RANDOM_NUMBER_MAX = 10;
    private static final Random RANDOM = new Random();

    private RandomGenerate() {
    }

    public static int pickRandomNumber() {
        return RANDOM.nextInt(RANDOM_NUMBER_MAX);
    }
}