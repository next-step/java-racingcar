package racingcar;

import java.util.Random;

public class Dice {
    private static final int MAXIMUM_VALUE = 10;

    private static Random RANDOM = new Random();

    public static int roll() {
        return RANDOM.nextInt(MAXIMUM_VALUE);
    }
}
