package racingcar.utils;

import java.util.Random;

public class Randoms {

    private static final Random RANDOM = new Random();
    private static final int CONDITION_MOVE_AVAILABLE = 4;

    private Randoms() {}

    public static int getRandomIntWithinRange(final int bound) {
        return RANDOM.nextInt(bound);
    }

    public static boolean moveAvailable(final int value) {
        if (value > CONDITION_MOVE_AVAILABLE) return true;
        return false;
    }

}
