package racingcar;

import java.util.Random;

public class Utils {
    private static final int RANDOM_NUMBER_BOUNDARY = 10;

    public static int generateRandomNum() {
        return new Random().nextInt(RANDOM_NUMBER_BOUNDARY);
    }
}
