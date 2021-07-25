package racingcar;

import java.util.Random;

public class RandomGenerate {

    private static final Random RANDOM = new Random();

    private RandomGenerate() {

    }

    public static boolean pick(int bound, int condition) {
        return RANDOM.nextInt(bound) >= condition;
    }
}
