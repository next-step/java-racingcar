package racinggame.utils;

import java.util.Random;

public abstract class RacingGameUtils {
    private static final int MAX_RANDOM_VALUE = 10;

    public static int generateRandomNumber() {
        return new Random().nextInt(MAX_RANDOM_VALUE);
    }
}
