package study.racingcar.utils;

import java.util.Random;

public class GameUtils {
    private static final Random random = new Random();
    public static final int RANDOM_BOUND_NUMBER = 10;

    public static int randomNumber() {
        return random.nextInt(RANDOM_BOUND_NUMBER);
    }
}
