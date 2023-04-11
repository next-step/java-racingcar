package study.racingcar;

import java.util.Random;

public class GenerateNumber {

    private static final Random RANDOM = new Random();
    private static final int BOUND_NUMBER = 10;

    public static int random() {
        return RANDOM.nextInt(BOUND_NUMBER);
    }
}
